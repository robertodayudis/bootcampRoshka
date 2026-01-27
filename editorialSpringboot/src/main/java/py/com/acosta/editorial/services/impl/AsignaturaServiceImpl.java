package py.com.acosta.editorial.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import py.com.acosta.editorial.model.Asignatura;
import py.com.acosta.editorial.repository.AsignaturaRepository;
import py.com.acosta.editorial.services.AsignaturaService;

@Service
public class AsignaturaServiceImpl extends AbstractCrudService<Asignatura, Integer>
        implements AsignaturaService {

    private final AsignaturaRepository repo;

    public AsignaturaServiceImpl(AsignaturaRepository repo) {
        this.repo = repo;
    }

    @Override
    protected JpaRepository<Asignatura, Integer> getRepository() {
        return repo;
    }
}
