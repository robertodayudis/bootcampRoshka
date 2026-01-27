package py.com.acosta.editorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.acosta.editorial.model.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
}
