package py.com.acosta.editorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.acosta.editorial.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
