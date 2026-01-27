package py.com.acosta.editorial.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.acosta.editorial.controllers.dto.PrestamoLibroCreateRequest;
import py.com.acosta.editorial.controllers.dto.PrestamoLibroUpdateRequest;
import py.com.acosta.editorial.controllers.dto.PrestamoLibroResponse;
import py.com.acosta.editorial.controllers.dto.PrestamoLibroItemResponse;
import py.com.acosta.editorial.model.PrestamoLibro;
import py.com.acosta.editorial.services.PrestamoLibroService;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoLibroController {

    private final PrestamoLibroService prestamoService;

    public PrestamoLibroController(PrestamoLibroService prestamoService) {
        this.prestamoService = prestamoService;
    }

    // Crea nuevo prestamo
    @PostMapping
    public ResponseEntity<PrestamoLibroResponse> crear(@RequestBody PrestamoLibroCreateRequest req) {
        PrestamoLibro p = prestamoService.crearPrestamo(
                req.getColProfeId(),
                req.getAsignaturaId(),
                req.getAulaId(),
                req.getCursoId(),
                LocalDate.parse(req.getFechaPrestamo()),
                req.getLibrosIds()
        );

        return ResponseEntity
                .created(URI.create("/api/prestamos/" + p.getId()))
                .body(toResponse(p));
    }

    // Obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<PrestamoLibroResponse> obtener(@PathVariable Integer id) {
        PrestamoLibro p = prestamoService.obtenerPorId(id);
        return ResponseEntity.ok(toResponse(p));
    }

    // Lista todos los prestamos
    @GetMapping
    public ResponseEntity<List<PrestamoLibroResponse>> listar() {
        List<PrestamoLibroResponse> resp = prestamoService.listar()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(resp);
    }

    // Actualiza (cambia por completo el prestamo
    @PutMapping("/{id}")
    public ResponseEntity<PrestamoLibroResponse> actualizar(@PathVariable Integer id,
                                                       @RequestBody PrestamoLibroUpdateRequest req) {

        PrestamoLibro p = prestamoService.actualizarPrestamo(
                id,
                req.getColProfeId(),
                req.getAsignaturaId(),
                req.getAulaId(),
                req.getCursoId(),
                LocalDate.parse(req.getFechaPrestamo()),
                req.getLibrosIds()
        );

        return ResponseEntity.ok(toResponse(p));
    }

    // Elimina prestamo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        prestamoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


//    Genera un nuevo objeto respuesta para evitar problemas con lazy
//    y demás, agrega null a los campos vacios en caso de existir
    private PrestamoLibroResponse toResponse(PrestamoLibro p) {

        var libros = p.getDetalles().stream()
                .map(det -> {
                    var libro = det.getLibro();
                    var editorial = libro.getEditorial();

                    return new PrestamoLibroItemResponse(
                            libro.getId(),
                            libro.getNombre(),
                            editorial.getId(),
                            editorial.getNombre()
                    );
                })
                .toList();

        return new PrestamoLibroResponse(
                p.getId(),
                p.getFechaPrestamo().toString(),

                // ColProfe
                p.getColprofe().getId(),
                p.getColprofe().getColegio().getNombre(),
                p.getColprofe().getProfesor().getNombre(),

                // Asignatura
                p.getAsignatura().getId(),
                p.getAsignatura().getNombre(),

                // Aula
                p.getAula().getId(),
                p.getAula().getNombre(),

                // Curso
                p.getCurso().getId(),
                p.getCurso().getNombre(),

                // Libros
                libros
        );
    }
}
