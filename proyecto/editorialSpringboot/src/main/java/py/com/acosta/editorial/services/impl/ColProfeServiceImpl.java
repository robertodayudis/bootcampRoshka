package py.com.acosta.editorial.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import py.com.acosta.editorial.model.Colegio;
import py.com.acosta.editorial.model.ColProfe;
import py.com.acosta.editorial.model.Profesor;
import py.com.acosta.editorial.repository.ColegioRepository;
import py.com.acosta.editorial.repository.ColProfeRepository;
import py.com.acosta.editorial.repository.ProfesorRepository;
import py.com.acosta.editorial.services.ColProfeService;

import java.util.List;

@Service
public class ColProfeServiceImpl implements ColProfeService {

    private final ColProfeRepository colProfeRepo;
    private final ColegioRepository colegioRepo;
    private final ProfesorRepository profesorRepo;

    public ColProfeServiceImpl(
            ColProfeRepository colProfeRepo,
            ColegioRepository colegioRepo,
            ProfesorRepository profesorRepo
    ) {
        this.colProfeRepo = colProfeRepo;
        this.colegioRepo = colegioRepo;
        this.profesorRepo = profesorRepo;
    }

    @Override
    @Transactional
    public ColProfe vincular(Integer colegioId, Integer profesorId) {
        if (colegioId == null || profesorId == null) {
            throw new IllegalArgumentException("colegioId y profesorId no pueden ser null");
        }

        // Rule: no duplicates
        if (colProfeRepo.existsByColegioIdAndProfesorId(colegioId, profesorId)) {
            throw new IllegalArgumentException("Ya existe el vínculo colegio-profesor (" + colegioId + ", " + profesorId + ")");
        }

        // Validate FK existence
        Colegio colegio = colegioRepo.findById(colegioId)
                .orElseThrow(() -> new IllegalArgumentException("Colegio no existe: " + colegioId));

        Profesor profesor = profesorRepo.findById(profesorId)
                .orElseThrow(() -> new IllegalArgumentException("Profesor no existe: " + profesorId));

        ColProfe cp = new ColProfe();
        cp.setColegio(colegio);
        cp.setProfesor(profesor);

        return colProfeRepo.save(cp);
    }

    @Override
    public List<ColProfe> listar() {
        return colProfeRepo.findAll();
    }

    @Override
    public List<ColProfe> listarPorColegio(Integer colegioId) {
        return colProfeRepo.findByColegioId(colegioId);
    }

    @Override
    public List<ColProfe> listarPorProfesor(Integer profesorId) {
        return colProfeRepo.findByProfesorId(profesorId);
    }

    @Override
    public ColProfe obtenerPorId(Integer id) {
        return colProfeRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ColProfe no existe: " + id));
    }

    // Fetch intentionally variant (safe for printing colegio/profesor fields)
    @Transactional
    public ColProfe obtenerPorIdConJoins(Integer id) {
        ColProfe cp = colProfeRepo.findByIdWithJoins(id);
        if (cp == null) {
            throw new IllegalArgumentException("ColProfe no existe: " + id);
        }
        return cp;
    }

    @Override
    @Transactional
    public void desvincular(Integer id) {
        ColProfe cp = obtenerPorId(id);

        // Optional rule:
        // If this ColProfe is used by PrestamoLibro, you may want to block deletion.
        // (Needs a repo query in PrestamoLibroRepository: existsByColprofeId(id))
        // For now: delete allowed
        colProfeRepo.delete(cp);
    }
}
