package mybootapp.manager;

import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.model.User;

import java.util.Collection;

public interface IDirectoryManager {

    Person findPerson(long personId);
    Group findGroup(long groupId);
    Collection<Person> findAllPersons();
    Collection<Group> findAllGroups();
    void saveGroup(Group g);
    void savePerson(Person p);
    void saveUser(User u);
    boolean isConnectedAs(Person person);
    <T> Collection<T> findByStringProperty(Class<T> clazz, String propertyName, String propertyValue);
    <T> T findOneByStringProperty(Class<T> clazz, String propertyName, String propertyValue);
    int count();

}
