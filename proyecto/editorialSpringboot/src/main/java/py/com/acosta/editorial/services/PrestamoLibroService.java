package py.com.acosta.editorial.services;

import py.com.acosta.editorial.model.PrestamoLibro;

import java.time.LocalDate;
import java.util.List;

public interface PrestamoLibroService {

    PrestamoLibro crearPrestamo(
            Integer colProfeId,
            Integer asignaturaId,
            Integer aulaId,
            Integer cursoId,
            LocalDate fechaPrestamo,
            List<Integer> librosIds
    );

    PrestamoLibro actualizarPrestamo(
            Integer prestamoId,
            Integer colProfeId,
            Integer asignaturaId,
            Integer aulaId,
            Integer cursoId,
            LocalDate fechaPrestamo,
            List<Integer> librosIds
    );

    PrestamoLibro obtenerPorId(Integer prestamoId);

    List<PrestamoLibro> listar();

    void eliminar(Integer prestamoId);
}
