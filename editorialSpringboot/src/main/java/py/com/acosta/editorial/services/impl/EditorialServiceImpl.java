package py.com.acosta.editorial.services.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import py.com.acosta.editorial.model.Editorial;
import py.com.acosta.editorial.repository.EditorialRepository;
import py.com.acosta.editorial.services.EditorialService;

@Service
public class EditorialServiceImpl
        extends AbstractCrudService<Editorial, Integer>
        implements EditorialService {

    private final EditorialRepository editorialRepo;

    public EditorialServiceImpl(EditorialRepository editorialRepo) {
        this.editorialRepo = editorialRepo;
    }

    @Override
    protected JpaRepository<Editorial, Integer> getRepository() {
        return editorialRepo;
    }
}
