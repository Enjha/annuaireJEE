package mybootapp.dao;

import mybootapp.model.Group;
import mybootapp.model.Person;

import java.util.Collection;

public interface IDao {

    <T> Collection<T> findAll(Class<T> clazz);
    Person findPerson(long id);
    Group findGroup(long id);
    void savePerson(Person p);
    void saveGroup(Group g);
    <T> void remove(Class<T> clazz, Object pk);

}
