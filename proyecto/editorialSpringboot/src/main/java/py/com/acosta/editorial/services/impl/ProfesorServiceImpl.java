package py.com.acosta.editorial.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import py.com.acosta.editorial.model.Profesor;
import py.com.acosta.editorial.repository.ProfesorRepository;
import py.com.acosta.editorial.services.ProfesorService;

@Service
public class ProfesorServiceImpl extends AbstractCrudService<Profesor, Integer>
        implements ProfesorService {

    private final ProfesorRepository repo;

    public ProfesorServiceImpl(ProfesorRepository repo) {
        this.repo = repo;
    }

    @Override
    protected JpaRepository<Profesor, Integer> getRepository() {
        return repo;
    }
}
