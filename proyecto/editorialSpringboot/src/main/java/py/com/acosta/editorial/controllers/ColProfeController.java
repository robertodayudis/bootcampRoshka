package py.com.acosta.editorial.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.acosta.editorial.controllers.dto.ColProfeCreateRequest;
import py.com.acosta.editorial.controllers.dto.ColProfeResponse;
import py.com.acosta.editorial.model.ColProfe;
import py.com.acosta.editorial.services.ColProfeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/colprofes")
public class ColProfeController {

    private final ColProfeService colProfeService;

    public ColProfeController(ColProfeService colProfeService) {
        this.colProfeService = colProfeService;
    }

    // Vincula id de profesor y colegio
    @PostMapping
    public ResponseEntity<ColProfeResponse> vincular(@RequestBody ColProfeCreateRequest req) {
        ColProfe colprofe = colProfeService.vincular(req.getColegioId(), req.getProfesorId());

        return ResponseEntity
                .created(URI.create("/api/colprofes/" + colprofe.getId()))
                .body(toResponseSafe(colprofe));
    }

    // Obtener relaciones colegio profesor /api/colprofes?colegioId=1  OR  ?profesorId=2  OR none
    @GetMapping
    public ResponseEntity<List<ColProfeResponse>> listar(
            @RequestParam(required = false) Integer colegioId,
            @RequestParam(required = false) Integer profesorId
    ) {
        List<ColProfe> lista;

        if (colegioId != null) {
            lista = colProfeService.listarPorColegio(colegioId);
        } else if (profesorId != null) {
            lista = colProfeService.listarPorProfesor(profesorId);
        } else {
            lista = colProfeService.listar();
        }

        List<ColProfeResponse> resp = lista.stream()
                .map(this::toResponseSafe)
                .toList();

        return ResponseEntity.ok(resp);
    }

    // Obtener relacion colegio profesor por id
    @GetMapping("/{id}")
    public ResponseEntity<ColProfeResponse> obtener(@PathVariable Integer id) {
        ColProfe colprofe = colProfeService.obtenerPorId(id);
        return ResponseEntity.ok(toResponseSafe(colprofe));
    }

    // Eliminar relacion colegio profesor por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desvincular(@PathVariable Integer id) {
        colProfeService.desvincular(id);
        return ResponseEntity.noContent().build();
    }


//    Genera un nuevo objeto respuesta para evitar problemas con lazy
//    y demás, agrega null a los campos vacios en caso de existir
    private ColProfeResponse toResponseSafe(ColProfe colprofe) {
        Integer colegioId = null;
        String colegioNombre = null;
        Integer profesorId = null;
        String profesorNombre = null;

        try {
            if (colprofe.getColegio() != null) {
                colegioId = colprofe.getColegio().getId();
                colegioNombre = colprofe.getColegio().getNombre();
            }
        } catch (Exception ignored) {}

        try {
            if (colprofe.getProfesor() != null) {
                profesorId = colprofe.getProfesor().getId();
                profesorNombre = colprofe.getProfesor().getNombre();
            }
        } catch (Exception ignored) {}

        return new ColProfeResponse(colprofe.getId(), colegioId, colegioNombre, profesorId, profesorNombre);
    }
}
