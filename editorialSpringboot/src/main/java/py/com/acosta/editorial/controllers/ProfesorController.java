package py.com.acosta.editorial.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.acosta.editorial.model.Profesor;
import py.com.acosta.editorial.services.ProfesorService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

//    Lista los profesores
    @GetMapping
    public ResponseEntity<List<Profesor>> listar() {
        return ResponseEntity.ok(profesorService.listar());
    }

//    Obtener profesor por id
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(profesorService.obtenerPorId(id));
    }

//    Crea nuevo profesor
    @PostMapping
    public ResponseEntity<Profesor> crear(@RequestBody Profesor profesor) {
        Profesor creado = profesorService.crear(profesor);
        return ResponseEntity
                .created(URI.create("/api/profesores/" + creado.getId()))
                .body(creado);
    }

//    Actualiza profesor
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizar(@PathVariable Integer id, @RequestBody Profesor profesor) {
        profesor.setId(id);
        Profesor actualizado = profesorService.actualizar(id, profesor);
        return ResponseEntity.ok(actualizado);
    }

//    Elimina profesor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        profesorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
