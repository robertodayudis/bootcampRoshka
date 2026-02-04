package py.com.acosta.editorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.acosta.editorial.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
