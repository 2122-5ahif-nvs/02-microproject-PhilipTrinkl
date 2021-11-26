package at.htl.graveyard.control;

import at.htl.graveyard.entity.Grave;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Model @ApplicationScoped
public class GraveRepository implements PanacheRepository<Grave> {

    @Inject
    EntityManager em;

    @Transactional
    public Grave save(Grave grave) {
        persist(grave);
        return grave;
    }

    @Transactional
    public void delete(long id) {
        delete("id",id);
    }

    @Transactional
    public void update(Grave grave){
        em.merge(grave);
    }

    public List<Grave> findAllGraves() {
        return listAll();
    }

    public Grave findById(long id) {
        return (Grave)find("id",id).firstResult();
    }
}
