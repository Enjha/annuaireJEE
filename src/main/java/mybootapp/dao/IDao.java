package mybootapp.dao;

import mybootapp.model.Group;
import mybootapp.model.Person;
import org.springframework.data.domain.Sort;

import java.util.Collection;
import java.util.List;

public interface IDao {
    <T> Collection<T> findAll(Class<T> clazz);
    Person findPerson(long id);
    Group findGroup(long id);
    void savePerson(Person p);
    void saveGroup(Group g);
    <T> void remove(Class<T> clazz, Object pk);
    <T> Collection<T> findByStringProperty(Class<T> clazz, String propertyName, String propertyValue);
    <T> T findOneByStringProperty(Class<T> clazz, String propertyName, String propertyValue);
}
