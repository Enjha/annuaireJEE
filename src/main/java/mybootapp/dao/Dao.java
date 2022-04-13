package mybootapp.dao;

import mybootapp.model.Group;
import mybootapp.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

@Repository("dao")
@Transactional
public class Dao implements IDao{

    @PersistenceContext
    EntityManager em;

    @Override
    public <T> Collection<T> findAll(Class<T> clazz) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        // clause SELECT de la requete
        cq.select(root);
        TypedQuery<T> tq = em.createQuery(cq);

        if (tq.getResultList().isEmpty())
            System.err.println("No entity found from " + clazz.getName() + ".");

        return tq.getResultList();
    }

    @Override
    public Person findPerson(long id) {
        if (em.find(Person.class, id) == null) {
            System.err.println("Entity not found.");
            return null;
        }else
            return em.find(Person.class, id);
    }

    @Override
    public Group findGroup(long id) {
        if (em.find(Group.class, id) == null) {
            System.err.println("Entity not found.");
            return null;
        }else
            return em.find(Group.class, id);
    }

    @Override
    public void savePerson(Person p) {
        if(findGroup(p.getId()) == null){
            em.persist(p);
            System.err.println("Entity added.");
        }else {
            em.merge(p);
            System.err.println("Entity updated.");
        }
    }

    @Override
    public void saveGroup(Group g) {
        if(findGroup(g.getId()) == null){
            em.persist(g);
            System.err.println("Entity added.");
        }else {
            em.merge(g);
            System.err.println("Entity updated.");
        }
    }

    @Override
    public <T> void remove(Class<T> clazz, Object pk) {
        T entity = em.find(clazz, pk);
        if (entity != null) {
            System.err.println("Entity removed.");
            em.remove(entity);
        }else{
            System.err.println("Entity doesn't exist.");
        }
    }
}

