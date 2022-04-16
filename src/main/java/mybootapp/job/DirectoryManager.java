package mybootapp.job;

import mybootapp.dao.IDao;
import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.model.User;
import mybootapp.web.Starter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collection;

@Service()
@ContextConfiguration(classes = Starter.class)
public class DirectoryManager implements IDirectoryManager{

    @Autowired
    IDao dao;

    @Override
    public Person findPerson(User user, String personId) {
        return null;
    }

    @Override
    public Group findGroup(long groupId) {
        return null;
    }

    @Override
    public Collection<Person> findAllPersons(User user, long groupId) {
        return null;
    }

    @Override
    public Collection<Group> findAllGroups() {
        return null;
    }

    @Override
    public boolean login(User user, String personId, String password) {
        return false;
    }

    @Override
    public void logout(User user) {

    }

    @Override
    public Person savePerson(User user, Person p) {
        return null;
    }

    @Override
    public boolean isConnectedAs(User user, Person person) {
        return false;
    }

    @Override
    public Collection<Person> findAllPersons(User user, String input) {
        return null;
    }

    @Override
    public Collection<Group> findAllGroups(String input) {
        return null;
    }
}
