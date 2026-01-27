package py.com.acosta.editorial.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.acosta.editorial.model.Editorial;
import py.com.acosta.editorial.services.EditorialService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {

    private final EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

//    Lista todas las editoriales
    @GetMapping
    public ResponseEntity<List<Editorial>> listar() {
        return ResponseEntity.ok(editorialService.listar());
    }

//    Obtener editorial por id
    @GetMapping("/{id}")
    public ResponseEntity<Editorial> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(editorialService.obtenerPorId(id));
    }

//    Crea nueva editorial
    @PostMapping
    public ResponseEntity<Editorial> crear(@RequestBody Editorial editorial) {
        Editorial creado = editorialService.crear(editorial);
        return ResponseEntity
                .created(URI.create("/api/editoriales/" + creado.getId()))
                .body(creado);
    }

//    Actualiza editorial
    @PutMapping("/{id}")
    public ResponseEntity<Editorial> actualizar(@PathVariable Integer id,
                                                @RequestBody Editorial editorial) {
        // Importante: aseguramos que el ID del body sea el del path
        editorial.setId(id);
        Editorial actualizado = editorialService.actualizar(id, editorial);
        return ResponseEntity.ok(actualizado);
    }

//    Elimia editorial por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        editorialService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
