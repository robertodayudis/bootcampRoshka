package py.com.acosta.editorial.services;

import py.com.acosta.editorial.model.Libro;

import java.util.List;

public interface LibroService {
    Libro crear(String nombre, Integer editorialId);

    Libro actualizar(Integer libroId, String nombre, Integer editorialId);

    Libro obtenerPorId(Integer libroId);

    List<Libro> listar();

    void eliminar(Integer libroId);
}
