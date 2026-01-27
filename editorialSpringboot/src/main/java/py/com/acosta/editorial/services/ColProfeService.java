package py.com.acosta.editorial.services;


import py.com.acosta.editorial.model.ColProfe;

import java.util.List;

public interface ColProfeService {
    ColProfe vincular(Integer colegioId, Integer profesorId);

    List<ColProfe> listar();

    List<ColProfe> listarPorColegio(Integer colegioId);

    List<ColProfe> listarPorProfesor(Integer profesorId);

    ColProfe obtenerPorId(Integer id);

    void desvincular(Integer id);
}
