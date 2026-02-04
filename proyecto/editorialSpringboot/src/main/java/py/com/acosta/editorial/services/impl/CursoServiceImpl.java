package py.com.acosta.editorial.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import py.com.acosta.editorial.model.Curso;
import py.com.acosta.editorial.repository.CursoRepository;
import py.com.acosta.editorial.services.CursoService;

@Service
public class CursoServiceImpl extends AbstractCrudService<Curso, Integer>
        implements CursoService {

    private final CursoRepository repo;

    public CursoServiceImpl(CursoRepository repo) {
        this.repo = repo;
    }

    @Override
    protected JpaRepository<Curso, Integer> getRepository() {
        return repo;
    }
}
