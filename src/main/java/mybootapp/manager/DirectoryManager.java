package mybootapp.manager;

import mybootapp.dao.IDao;
import mybootapp.dao.SpringConfiguration;
import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.model.User;
import mybootapp.web.Starter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collection;

@Service
@ContextConfiguration(classes = SpringConfiguration.class)
public class DirectoryManager implements IDirectoryManager{

    @Autowired
    IDao dao;

    @Override
    public Person findPerson(long personId) {
        return dao.find(Person.class,personId);
    }

    @Override
    public Group findGroup(long groupId) {
        return dao.find(Group.class,groupId);
    }

    @Override
    public Collection<Person> findAllPersons() {
        return dao.findAll(Person.class);
    }

    @Override
    public Collection<Group> findAllGroups() {
        return dao.findAll(Group.class);
    }

    @Override
    public void saveGroup(Group g) {
        if(dao.find(Group.class, g.getId()) != null)
            dao.update(g);
        else
            dao.add(g);
    }

    @Override
    public void savePerson(Person p) {
        if(dao.find(Person.class, p.getId()) != null)
            dao.update(p);
        else
            dao.add(p);
    }

    @Override
    public void saveUser(User u) {
        for(User user : dao.findAll(User.class)){
            if(user.equals(u)){
                dao.update(u);
                return;
            }
        }
        dao.add(u);
    }

    @Override
    public boolean isConnectedAs(Person person) {
        return SecurityContextHolder.getContext().getAuthentication().getName().equals(person.getEmail());
    }

    @Override
    public <T> Collection<T> findByStringProperty(Class<T> clazz, String propertyName, String propertyValue) {
        return dao.findByStringProperty(clazz, propertyName, propertyValue);
    }

    @Override
    public <T> T findOneByStringProperty(Class<T> clazz, String propertyName, String propertyValue) {
        return dao.findOneByStringProperty(clazz, propertyName, propertyValue);
    }

    @Override
    public int count() {
        return dao.findAll(Group.class).size();
    }
}
