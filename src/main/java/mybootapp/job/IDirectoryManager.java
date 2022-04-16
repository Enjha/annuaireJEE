package mybootapp.job;

import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.model.User;

import java.util.Collection;

public interface IDirectoryManager {

    Person findPerson(User user, String personId);
    Group findGroup(long groupId);
    Collection<Person> findAllPersons(User user, long groupId);
    Collection<Group> findAllGroups();
    boolean login(User user, String personId, String password);
    void logout(User user);
    Person savePerson(User user, Person p);
    boolean isConnectedAs(User user, Person person);
    Collection<Person> findAllPersons(User user, String input);
    Collection<Group> findAllGroups(String input);

}
