package py.com.acosta.editorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.acosta.editorial.model.Aula;

public interface AulaRepository extends JpaRepository <Aula, Integer> {
}
