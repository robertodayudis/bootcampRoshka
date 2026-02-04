package py.com.acosta.editorial.services.impl;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import py.com.acosta.editorial.services.CrudService;

import java.util.List;

public abstract class AbstractCrudService<T, ID>
        implements CrudService<T, ID> {

    /**
     * Cada service concreto debe decir
     * cuál es su repository.
     */
    protected abstract JpaRepository<T, ID> getRepository();

    protected RuntimeException notFound(ID id) {
        return new IllegalArgumentException(
                "No existe registro con id: " + id
        );
    }

    @Override
    @Transactional
    public T crear(T entity) {
        return getRepository().save(entity);
    }

    @Override
    @Transactional
    public T actualizar(ID id, T entity) {
        // fuerza existencia antes de actualizar
        getRepository()
                .findById(id)
                .orElseThrow(() -> notFound(id));

        return getRepository().save(entity);
    }

    @Override
    public T obtenerPorId(ID id) {
        return getRepository()
                .findById(id)
                .orElseThrow(() -> notFound(id));
    }

    @Override
    public List<T> listar() {
        return getRepository().findAll();
    }

    @Override
    @Transactional
    public void eliminar(ID id) {
        T entity = obtenerPorId(id);
        getRepository().delete(entity);
    }
}
