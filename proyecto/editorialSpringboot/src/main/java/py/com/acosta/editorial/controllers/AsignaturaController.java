package py.com.acosta.editorial.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.acosta.editorial.model.Asignatura;
import py.com.acosta.editorial.services.AsignaturaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

//    Lista todas las asignaturas
    @GetMapping
    public ResponseEntity<List<Asignatura>> listar() {
        return ResponseEntity.ok(asignaturaService.listar());
    }

//  Obtiene por id una asignatura
    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(asignaturaService.obtenerPorId(id));
    }

//    Crea una asignatura
    @PostMapping
    public ResponseEntity<Asignatura> crear(@RequestBody Asignatura asignatura) {
        Asignatura creado = asignaturaService.crear(asignatura);
        return ResponseEntity
                .created(URI.create("/api/asignaturaes/" + creado.getId()))
                .body(creado);
    }

//    Actualiza una asignatura
    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> actualizar(@PathVariable Integer id, @RequestBody Asignatura asignatura) {
        asignatura.setId(id);
        Asignatura actualizado = asignaturaService.actualizar(id, asignatura);
        return ResponseEntity.ok(actualizado);
    }

//    Elimina una asignatura
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        asignaturaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
