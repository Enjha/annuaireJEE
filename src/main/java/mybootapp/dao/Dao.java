package mybootapp.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;
import java.util.Collection;
import java.util.List;

@Service
@Repository
@Transactional
public class Dao implements IDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public <T> Collection<T> findAll(Class<T> clazz) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.select(root);
        TypedQuery<T> tq = em.createQuery(cq);

        if (tq.getResultList().isEmpty())
            System.err.println("No entity found from " + clazz.getName() + ".");

        return tq.getResultList();
    }

    @Override
    public <T> T find(Class<T> clazz, long id) {
        if (em.find(clazz, id) == null) {
            return null;
        } else
            return em.find(clazz, id);
    }

    @Override
    public <T> Collection<T> findByStringProperty(Class<T> clazz, String propertyName, String propertyValue) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> root = cq.from(clazz);

        Metamodel m = em.getMetamodel();
        EntityType<T> Person_ = m.entity(clazz);
        SingularAttribute<T, String> propertyValueMeta = Person_.getDeclaredSingularAttribute(propertyName,
                String.class);

        cq.where(cb.like(root.get(propertyValueMeta), propertyValue));
        TypedQuery<T> q = em.createQuery(cq);
        List<T> resultList = q.getResultList();

        if (resultList.isEmpty())
            System.err.println("No " + clazz.getName() + " found.");
        else
            System.err.println(resultList.size() + " " + clazz.getName() + " found.");

        return resultList;
    }

    @Override
    public <T> T findOneByStringProperty(Class<T> clazz, String propertyName, String propertyValue) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> root = cq.from(clazz);

        Metamodel m = em.getMetamodel();
        EntityType<T> Person_ = m.entity(clazz);
        SingularAttribute<T, String> propertyValueMeta = Person_.getDeclaredSingularAttribute(propertyName,
                String.class);

        cq.where(cb.like(root.get(propertyValueMeta), propertyValue));
        TypedQuery<T> q = em.createQuery(cq);

        return q.getSingleResult();
    }

    @Override
    public <T> void add(T entity) {
        em.persist(entity);
    }

    @Override
    public <T> void update(T entity) {
        em.merge(entity);
    }
}
