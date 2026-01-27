package py.com.acosta.editorial.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.acosta.editorial.model.Aula;
import py.com.acosta.editorial.services.AulaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {
    private final AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

//    Lista todas las aulas
    @GetMapping
    public ResponseEntity<List<Aula>> listar() {
        return ResponseEntity.ok(aulaService.listar());
    }

//    Obtiene por id un aula
    @GetMapping("/{id}")
    public ResponseEntity<Aula> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(aulaService.obtenerPorId(id));
    }

//    Crea aula
    @PostMapping
    public ResponseEntity<Aula> crear(@RequestBody Aula aula) {
        Aula creado = aulaService.crear(aula);
        return ResponseEntity
                .created(URI.create("/api/aulas/" + creado.getId()))
                .body(creado);
    }

//    Actualiza aula
    @PutMapping("/{id}")
    public ResponseEntity<Aula> actualizar(@PathVariable Integer id, @RequestBody Aula aula) {
        aula.setId(id);
        Aula actualizado = aulaService.actualizar(id, aula);
        return ResponseEntity.ok(actualizado);
    }

//    Elimina aula
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        aulaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
