package py.com.acosta.editorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.acosta.editorial.model.Profesor;

public interface ProfesorRepository extends JpaRepository <Profesor, Integer> {
}
