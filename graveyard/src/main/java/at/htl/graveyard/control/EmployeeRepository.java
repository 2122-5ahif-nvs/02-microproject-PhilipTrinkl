package at.htl.graveyard.control;

import at.htl.graveyard.entity.Employee;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Model @ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {
    @Inject
    EntityManager em;

    @Transactional
    public Employee save(Employee employee){
        persist(employee);
        return employee;
    }

    @Transactional
    public void delete(long id){
       delete("id", id);
    }

    @Transactional
    public void update(Employee employee){
        em.merge(employee);
    }

    public List<Employee> findAllEmployees(){
        return listAll();
    }

    public Employee findById(long id){
        return (Employee)find("id",id).firstResult();
    }
}
