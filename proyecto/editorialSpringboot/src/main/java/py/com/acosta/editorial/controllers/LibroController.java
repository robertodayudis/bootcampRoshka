package py.com.acosta.editorial.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.acosta.editorial.controllers.dto.LibroCreateRequest;
import py.com.acosta.editorial.controllers.dto.LibroResponse;
import py.com.acosta.editorial.controllers.dto.LibroUpdateRequest;
import py.com.acosta.editorial.model.Editorial;
import py.com.acosta.editorial.model.Libro;
import py.com.acosta.editorial.services.LibroService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

//    Listar
    @GetMapping
    public ResponseEntity<List<LibroResponse>> listar() {
        List<LibroResponse> resp = libroService.listar()
                .stream()
                .map(this::toResponseSafe)
                .toList();

        return ResponseEntity.ok(resp);
    }

//    Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<LibroResponse> obtener(@PathVariable Integer id) {
        Libro libro = libroService.obtenerPorId(id);
        return ResponseEntity.ok(toResponseSafe(libro));
    }

//    Crear
    @PostMapping
    public ResponseEntity<LibroResponse> crear(@RequestBody LibroCreateRequest req) {
        Libro creado = libroService.crear(req.getNombre(), req.getEditorialId());

        return ResponseEntity
                .created(URI.create("/api/libros/" + creado.getId()))
                .body(toResponseSafe(creado));
    }

//    Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<LibroResponse> actualizar(@PathVariable Integer id,
                                                    @RequestBody LibroUpdateRequest req) {

        Libro actualizado = libroService.actualizar(id, req.getNombre(), req.getEditorialId());
        return ResponseEntity.ok(toResponseSafe(actualizado));
    }

//    Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        libroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

//    Genera un nuevo objeto respuesta para evitar problemas con lazy
//    y demás, agrega null a los campos vacios en caso de existir
    private LibroResponse toResponseSafe(Libro libro) {
        Editorial e = null;
        try {
            e = libro.getEditorial();
        } catch (Exception ignored) {}

        Integer editorialId = (e != null ? e.getId() : null);
        String editorialNombre = (e != null ? e.getNombre() : null);

        return new LibroResponse(
                libro.getId(),
                libro.getNombre(),
                editorialId,
                editorialNombre
        );
    }
}
