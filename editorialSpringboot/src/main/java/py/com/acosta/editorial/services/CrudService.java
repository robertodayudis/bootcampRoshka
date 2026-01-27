package py.com.acosta.editorial.services;

import java.util.List;

public interface CrudService<T, ID> {

    T crear(T entity);

    T actualizar(ID id, T entity);

    T obtenerPorId(ID id);

    List<T> listar();

    void eliminar(ID id);
}
