package py.com.acosta.editorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.acosta.editorial.model.PrestamoLibro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PrestamoLibroRepository extends JpaRepository<PrestamoLibro, Integer> {
    @Query("""
           select distinct p
           from PrestamoLibro p
           left join fetch p.detalles d
           left join fetch d.libro l
           left join fetch l.editorial e
           where p.id = :id
           """)
    Optional<PrestamoLibro> findByIdWithDetallesLibrosEditorial(@Param("id") Integer id);

    @Query("""
           select distinct p
           from PrestamoLibro p
           left join fetch p.detalles d
           left join fetch d.libro l
           left join fetch l.editorial e
           """)
    List<PrestamoLibro> findAllWithDetallesLibrosEditorial();

    @Query("""
           select distinct p
           from PrestamoLibro p
           join fetch p.colprofe cp
           join fetch cp.colegio c
           join fetch cp.profesor pr
           join fetch p.asignatura a
           join fetch p.aula au
           join fetch p.curso cu
           left join fetch p.detalles d
           left join fetch d.libro l
           left join fetch l.editorial e
           """)
    List<PrestamoLibro> findAllFull();

    @Query("""
           select distinct p
           from PrestamoLibro p
           join fetch p.colprofe cp
           join fetch cp.colegio c
           join fetch cp.profesor pr
           join fetch p.asignatura a
           join fetch p.aula au
           join fetch p.curso cu
           left join fetch p.detalles d
           left join fetch d.libro l
           left join fetch l.editorial e
           where p.id = :id
           """)
    Optional<PrestamoLibro> findByIdFull(@Param("id") Integer id);
}

