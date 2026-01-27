package py.com.acosta.editorial.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import py.com.acosta.editorial.model.Editorial;
import py.com.acosta.editorial.model.Libro;
import py.com.acosta.editorial.repository.DetallePrestamoRepository;
import py.com.acosta.editorial.repository.EditorialRepository;
import py.com.acosta.editorial.repository.LibroRepository;
import py.com.acosta.editorial.services.LibroService;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepo;
    private final EditorialRepository editorialRepo;
    private final DetallePrestamoRepository detallePrestamoRepo; // only needed if you block deletes

    public LibroServiceImpl(
            LibroRepository libroRepo,
            EditorialRepository editorialRepo,
            DetallePrestamoRepository detallePrestamoRepo
    ) {
        this.libroRepo = libroRepo;
        this.editorialRepo = editorialRepo;
        this.detallePrestamoRepo = detallePrestamoRepo;
    }

    @Override
    @Transactional
    public Libro crear(String nombre, Integer editorialId) {
        validarNombre(nombre);

        Editorial editorial = editorialRepo.findById(editorialId)
                .orElseThrow(() -> new IllegalArgumentException("Editorial no existe: " + editorialId));

        Libro libro = new Libro();
        libro.setNombre(nombre.trim());
        libro.setEditorial(editorial);

        return libroRepo.save(libro);
    }

    @Override
    @Transactional
    public Libro actualizar(Integer libroId, String nombre, Integer editorialId) {
        validarNombre(nombre);

        Libro libro = libroRepo.findById(libroId)
                .orElseThrow(() -> new IllegalArgumentException("Libro no existe: " + libroId));

        Editorial editorial = editorialRepo.findById(editorialId)
                .orElseThrow(() -> new IllegalArgumentException("Editorial no existe: " + editorialId));

        libro.setNombre(nombre.trim());
        libro.setEditorial(editorial);

        return libroRepo.save(libro);
    }

    @Override
    public Libro obtenerPorId(Integer libroId) {
        return libroRepo.findById(libroId)
                .orElseThrow(() -> new IllegalArgumentException("Libro no existe: " + libroId));
    }

    @Override
    public List<Libro> listar() {
        return libroRepo.findAll();
    }

    @Override
    @Transactional
    public void eliminar(Integer libroId) {
        Libro libro = obtenerPorId(libroId);

        // Recommended rule: don't delete if already used in loan details
        // Requires: boolean existsByLibroId(Integer libroId) in DetallePrestamoRepository
        if (detallePrestamoRepo.existsByLibroId(libroId)) {
            throw new IllegalArgumentException("No se puede eliminar: el libro está usado en detalle_prestamo (id=" + libroId + ")");
        }

        libroRepo.delete(libro);
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("nombre no puede ser vacío");
        }
    }
}
