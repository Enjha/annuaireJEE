package mybootapp.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import mybootapp.model.XUser;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mybootapp.model.Group;
import mybootapp.model.Person;

@Service
@Repository("Dao")
@Transactional
public class Dao {

    @PersistenceContext
    EntityManager em;

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

    public Person findPerson(long id) {
        if (em.find(Person.class, id) == null) {
            return null;
        }else
            return em.find(Person.class, id);
    }

    public Group findGroup(long id) {
        if (em.find(Group.class, id) == null) {
            return null;
        }else
            return em.find(Group.class, id);
    }

    public void savePerson(Person p) {
        if(findGroup(p.getId()) == null){
            em.persist(p);
        }else {
            em.merge(p);
        }
    }

    public void saveGroup(Group g) {
        if(findGroup(g.getId()) == null){
            em.persist(g);
        }else {
            em.merge(g);
        }
    }

    public <T> void remove(Class<T> clazz, Object pk) {
        T entity = em.find(clazz, pk);
        if (entity != null) {
            em.remove(entity);
        }else{
            System.err.println("Entity doesn't exist.");
        }
    }
}
