package at.htl.graveyard.control;

import at.htl.graveyard.entity.Gravestone;
import at.htl.graveyard.entity.Graveyard;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Model @ApplicationScoped
public class GraveyardRepository implements PanacheRepository<Graveyard> {
    @Inject
    EntityManager em;

    @Transactional
    public Graveyard save(Graveyard graveyard){
        persist(graveyard);
        return graveyard;
    }

    @Transactional
    public void delete(long id){
        delete("id",id);
    }

    @Transactional
    public void update(Gravestone gravestone){
        em.merge(gravestone);
    }

    public List<Graveyard> findAllGraveyards(){
        return listAll();
    }

    public Graveyard findById(long id){
        return (Graveyard)find("id",id).firstResult();
    }

    public Graveyard findByName(String name){
        return (Graveyard)find("NAME",name).firstResult();
    }
}
