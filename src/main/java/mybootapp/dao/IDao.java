package mybootapp.dao;

import mybootapp.model.Group;
import mybootapp.model.Person;

import java.util.Collection;

public interface IDao {

    public <T> Collection<T> findAll(Class<T> clazz);
    public Person findPerson(long id);
    public Group findGroup(long id);
    public void savePerson(Person p);
    public void saveGroup(Group g);
    public <T> void remove(Class<T> clazz, Object pk);

}
