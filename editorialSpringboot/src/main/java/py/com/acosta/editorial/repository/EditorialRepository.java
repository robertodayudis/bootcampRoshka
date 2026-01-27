package py.com.acosta.editorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.acosta.editorial.model.Editorial;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
}
