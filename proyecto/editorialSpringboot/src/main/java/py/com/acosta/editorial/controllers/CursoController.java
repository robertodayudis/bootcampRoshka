package py.com.acosta.editorial.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.acosta.editorial.model.Curso;
import py.com.acosta.editorial.services.CursoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

//    Lista todos los cursos
    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        return ResponseEntity.ok(cursoService.listar());
    }

//    Obtiene curso por id
    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(cursoService.obtenerPorId(id));
    }

//    Crear nuevo curso
    @PostMapping
    public ResponseEntity<Curso> crear(@RequestBody Curso curso) {
        Curso creado = cursoService.crear(curso);
        return ResponseEntity
                .created(URI.create("/api/cursoes/" + creado.getId()))
                .body(creado);
    }

//    Actualizar curso
    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        curso.setId(id);
        Curso actualizado = cursoService.actualizar(id, curso);
        return ResponseEntity.ok(actualizado);
    }

//    Eliminar curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
