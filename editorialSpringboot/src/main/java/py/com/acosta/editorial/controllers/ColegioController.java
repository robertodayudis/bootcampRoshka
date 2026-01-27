package py.com.acosta.editorial.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.acosta.editorial.model.Colegio;
import py.com.acosta.editorial.services.ColegioService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/colegios")
public class ColegioController {

    private final ColegioService colegioService;

    public ColegioController(ColegioService colegioService) {
        this.colegioService = colegioService;
    }

//    Lista todos los colegios
    @GetMapping
    public ResponseEntity<List<Colegio>> listar() {
        return ResponseEntity.ok(colegioService.listar());
    }

//    Obtiene por id un colegio
    @GetMapping("/{id}")
    public ResponseEntity<Colegio> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(colegioService.obtenerPorId(id));
    }

//    Crea un colegio
    @PostMapping
    public ResponseEntity<Colegio> crear(@RequestBody Colegio colegio) {
        Colegio creado = colegioService.crear(colegio);
        return ResponseEntity
                .created(URI.create("/api/colegioes/" + creado.getId()))
                .body(creado);
    }

//    Actualiza un colegio
    @PutMapping("/{id}")
    public ResponseEntity<Colegio> actualizar(@PathVariable Integer id, @RequestBody Colegio colegio) {
        colegio.setId(id);
        Colegio actualizado = colegioService.actualizar(id, colegio);
        return ResponseEntity.ok(actualizado);
    }

//    Elimina un colegio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        colegioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
