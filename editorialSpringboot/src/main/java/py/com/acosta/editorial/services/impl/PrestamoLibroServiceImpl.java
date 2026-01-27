package py.com.acosta.editorial.services.impl;

//import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import py.com.acosta.editorial.model.*;
import py.com.acosta.editorial.repository.*;
import py.com.acosta.editorial.services.PrestamoLibroService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PrestamoLibroServiceImpl implements PrestamoLibroService {

    private final PrestamoLibroRepository prestamoRepo;
    private final DetallePrestamoRepository detalleRepo;

    private final ColProfeRepository colProfeRepo;
    private final AsignaturaRepository asignaturaRepo;
    private final AulaRepository aulaRepo;
    private final CursoRepository cursoRepo;
    private final LibroRepository libroRepo;

    public PrestamoLibroServiceImpl(
            PrestamoLibroRepository prestamoRepo,
            DetallePrestamoRepository detalleRepo,
            ColProfeRepository colProfeRepo,
            AsignaturaRepository asignaturaRepo,
            AulaRepository aulaRepo,
            CursoRepository cursoRepo,
            LibroRepository libroRepo
    ) {
        this.prestamoRepo = prestamoRepo;
        this.detalleRepo = detalleRepo;
        this.colProfeRepo = colProfeRepo;
        this.asignaturaRepo = asignaturaRepo;
        this.aulaRepo = aulaRepo;
        this.cursoRepo = cursoRepo;
        this.libroRepo = libroRepo;
    }

    @Override
    @Transactional
    public PrestamoLibro crearPrestamo(
            Integer colProfeId,
            Integer asignaturaId,
            Integer aulaId,
            Integer cursoId,
            LocalDate fechaPrestamo,
            List<Integer> librosIds
    ) {
        // ---- Basic validations (business rules) ----
        if (fechaPrestamo == null) {
            throw new IllegalArgumentException("fechaPrestamo no puede ser null");
        }
        if (librosIds == null || librosIds.isEmpty()) {
            throw new IllegalArgumentException("Debe incluir al menos 1 libro en el préstamo");
        }

        // Optional: prevent duplicates inside the same loan
        Set<Integer> uniqueLibros = new HashSet<>(librosIds);
        if (uniqueLibros.size() != librosIds.size()) {
            throw new IllegalArgumentException("La lista de libros contiene IDs duplicados");
        }

        // ---- Validate foreign keys exist ----
        ColProfe colProfe = colProfeRepo.findById(colProfeId)
                .orElseThrow(() -> new IllegalArgumentException("ColProfe no existe: " + colProfeId));

        Asignatura asignatura = asignaturaRepo.findById(asignaturaId)
                .orElseThrow(() -> new IllegalArgumentException("Asignatura no existe: " + asignaturaId));

        Aula aula = aulaRepo.findById(aulaId)
                .orElseThrow(() -> new IllegalArgumentException("Aula no existe: " + aulaId));

        Curso curso = cursoRepo.findById(cursoId)
                .orElseThrow(() -> new IllegalArgumentException("Curso no existe: " + cursoId));

        // ---- Create and save PrestamoLibro (header) ----
        PrestamoLibro prestamo = new PrestamoLibro();

        /*
         * ⚠️ IMPORTANT:
         * Set these according to YOUR entity mapping.
         * If PrestamoLibro has ManyToOne relations, you set objects:
         */
        prestamo.setColprofe(colProfe);
        prestamo.setAsignatura(asignatura);
        prestamo.setAula(aula);
        prestamo.setCurso(curso);

        /*
         * If your PrestamoLibro stores only integer FK fields (less common with JPA),
         * you’d do:
         * prestamo.setIdColProfe(colProfeId);
         * prestamo.setIdAsignatura(asignaturaId);
         * ...
         */

        prestamo.setFechaPrestamo(fechaPrestamo);

        PrestamoLibro prestamoGuardado = prestamoRepo.save(prestamo);

        // ---- Create details (DetallePrestamo) ----
        for (Integer libroId : uniqueLibros) {
            Libro libro = libroRepo.findById(libroId)
                    .orElseThrow(() -> new IllegalArgumentException("Libro no existe: " + libroId));

            DetallePrestamo detalle = new DetallePrestamo();

            /*
             * Again depends on your mapping:
             * If DetallePrestamo has ManyToOne to PrestamoLibro and Libro:
             */
            detalle.setPrestamo(prestamoGuardado);
            detalle.setLibro(libro);

            /*
             * If you modeled as integer fields:
             * detalle.setIdPrestamo(prestamoGuardado.getId());
             * detalle.setIdLibro(libroId);
             */

            detalleRepo.save(detalle);
        }

        return prestamoGuardado;
    }

    @Override
    @Transactional
    public PrestamoLibro actualizarPrestamo(Integer prestamoId,
                                            Integer colProfeId,
                                            Integer asignaturaId,
                                            Integer aulaId,
                                            Integer cursoId,
                                            LocalDate fechaPrestamo,
                                            List<Integer> librosIds) {

        if (fechaPrestamo == null) {
            throw new IllegalArgumentException("fechaPrestamo es obligatorio");
        }
        if (librosIds == null || librosIds.isEmpty()) {
            throw new IllegalArgumentException("Debe indicar al menos un libro (librosIds)");
        }

        PrestamoLibro prestamo = prestamoRepo.findById(prestamoId)
                .orElseThrow(() -> new IllegalArgumentException("Prestamo no existe: " + prestamoId));

        ColProfe colProfe = colProfeRepo.findById(colProfeId)
                .orElseThrow(() -> new IllegalArgumentException("ColProfe no existe: " + colProfeId));

        Asignatura asignatura = asignaturaRepo.findById(asignaturaId)
                .orElseThrow(() -> new IllegalArgumentException("Asignatura no existe: " + asignaturaId));

        Aula aula = aulaRepo.findById(aulaId)
                .orElseThrow(() -> new IllegalArgumentException("Aula no existe: " + aulaId));

        Curso curso = cursoRepo.findById(cursoId)
                .orElseThrow(() -> new IllegalArgumentException("Curso no existe: " + cursoId));

        // 1) Update header fields
        prestamo.setColprofe(colProfe);
        prestamo.setAsignatura(asignatura);
        prestamo.setAula(aula);
        prestamo.setCurso(curso);
        prestamo.setFechaPrestamo(fechaPrestamo);

        // 2) Replace detalles (full replace)
        // orphanRemoval=true -> removing from list deletes rows in detalle_prestamo
        prestamo.getDetalles().clear();

        for (Integer libroId : librosIds) {
            Libro libro = libroRepo.findById(libroId)
                    .orElseThrow(() -> new IllegalArgumentException("Libro no existe: " + libroId));

            DetallePrestamo det = new DetallePrestamo();
            det.setPrestamo(prestamo); // must match your field name in DetallePrestamo
            det.setLibro(libro);       // must match your field name in DetallePrestamo

            prestamo.getDetalles().add(det);
        }

        // 3) Save
        // Because PrestamoLibro is the owning side for cascade to detalles, save is enough.
        return prestamoRepo.save(prestamo);
    }

    @Override
    @Transactional
    public void eliminar(Integer prestamoId) {
        PrestamoLibro prestamo = obtenerPorId(prestamoId);

        /*
         * If you DON'T have cascade delete from PrestamoLibro -> DetallePrestamo,
         * you must delete details first.
         *
         * That requires a repository method like:
         * detalleRepo.deleteByPrestamoId(prestamoId);
         *
         * If you DO have cascade configured, then prestamoRepo.delete(prestamo) is enough.
         */

        prestamoRepo.delete(prestamo);
    }

    @Override
    @Transactional(readOnly = true)
    public PrestamoLibro obtenerPorId(Integer prestamoId) {
        return prestamoRepo.findByIdFull(prestamoId)
                .orElseThrow(() -> new IllegalArgumentException("Prestamo no existe: " + prestamoId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrestamoLibro> listar() {
        return prestamoRepo.findAllFull();
    }
}
