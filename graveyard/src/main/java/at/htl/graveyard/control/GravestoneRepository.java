package at.htl.graveyard.control;

import at.htl.graveyard.entity.Grave;
import at.htl.graveyard.entity.Gravestone;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Model @ApplicationScoped
public class GravestoneRepository implements PanacheRepository<Gravestone> {
    @Inject
    EntityManager em;

    @Transactional
    public Gravestone save(Gravestone gravestone) {
        persist(gravestone);
        return gravestone;
    }

    @Transactional
    public void delete(long id) {
        delete("id", id);
    }

    @Transactional
    public void update(Gravestone gravestone){
        em.merge(gravestone);
    }

    public List<Gravestone> findAllGravestones() {
        return listAll();
    }

    public Gravestone findById(long id) {
        return (Gravestone)find("id",id).firstResult();
    }

    public Gravestone findByName(String name) {
        return (Gravestone)find("NAME",name).firstResult();
    }
}
