package py.com.acosta.editorial.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import py.com.acosta.editorial.model.Aula;
import py.com.acosta.editorial.repository.AulaRepository;
import py.com.acosta.editorial.services.AulaService;

@Service
public class AulaServiceImpl extends AbstractCrudService<Aula, Integer>
        implements AulaService {

    private final AulaRepository repo;

    public AulaServiceImpl(AulaRepository repo) {
        this.repo = repo;
    }

    @Override
    protected JpaRepository<Aula, Integer> getRepository() {
        return repo;
    }
}
