package py.com.acosta.editorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import py.com.acosta.editorial.model.ColProfe;

import java.util.List;

public interface ColProfeRepository extends JpaRepository<ColProfe, Integer> {
    boolean existsByColegioIdAndProfesorId(Integer colegioId, Integer profesorId);

    List<ColProfe> findByColegioId(Integer colegioId);

    List<ColProfe> findByProfesorId(Integer profesorId);
    // Intentional fetch: brings colegio + profesor loaded in one query
    @Query("""
           select cp
           from ColProfe cp
           join fetch cp.colegio
           join fetch cp.profesor
           where cp.id = :id
           """)
    ColProfe findByIdWithJoins(@Param("id") Integer id);

    @Query("""
           select cp
           from ColProfe cp
           join fetch cp.colegio
           join fetch cp.profesor
           where cp.colegio.id = :colegioId
           """)
    List<ColProfe> findByColegioIdWithJoins(@Param("colegioId") Integer colegioId);
    @Query("""
           select cp
           from ColProfe cp
           join fetch cp.colegio
           join fetch cp.profesor
           where cp.profesor.id = :profesorId
           """)
    List<ColProfe> findByProfesorIdWithJoins(@Param("profesorId") Integer profesorId);
}
