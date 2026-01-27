package py.com.acosta.editorial.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import py.com.acosta.editorial.model.Colegio;
import py.com.acosta.editorial.repository.ColegioRepository;
import py.com.acosta.editorial.services.ColegioService;

@Service
public class ColegioServiceImpl extends AbstractCrudService<Colegio, Integer>
        implements ColegioService {

    private final ColegioRepository repo;

    public ColegioServiceImpl(ColegioRepository repo) {
        this.repo = repo;
    }

    @Override
    protected JpaRepository<Colegio, Integer> getRepository() {
        return repo;
    }
}
