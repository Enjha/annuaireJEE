package mybootapp.dao;

import java.util.Collection;

public interface IDao {
    <T> Collection<T> findAll(Class<T> clazz);
    <T> T find(Class<T> clazz, long id);
    <T> void remove(Class<T> clazz, Object pk);
    <T> Collection<T> findByStringProperty(Class<T> clazz, String propertyName, String propertyValue);
    <T> T findOneByStringProperty(Class<T> clazz, String propertyName, String propertyValue);
    <T> void add(T entity);
    <T> void update(T entity);
}
