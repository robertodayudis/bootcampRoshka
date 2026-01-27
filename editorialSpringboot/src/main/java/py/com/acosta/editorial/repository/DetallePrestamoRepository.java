package py.com.acosta.editorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.acosta.editorial.model.DetallePrestamo;

public interface DetallePrestamoRepository extends JpaRepository<DetallePrestamo, Integer> {

    boolean existsByLibroId(Integer libroId);
}
