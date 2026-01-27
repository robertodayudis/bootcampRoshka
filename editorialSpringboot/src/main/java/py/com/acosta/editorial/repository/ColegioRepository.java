package py.com.acosta.editorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.acosta.editorial.model.Colegio;

public interface ColegioRepository extends JpaRepository<Colegio, Integer> {
}
