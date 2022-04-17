package mybootapp.jpa;

import mybootapp.dao.Dao;
import mybootapp.manager.IDirectoryManager;
import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.model.User;

import mybootapp.web.Starter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;
import java.util.Calendar;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Dao.class)
@ContextConfiguration(classes = Starter.class)
public class TestRepository {

    @Autowired
    Dao dao;

    @Autowired
    IDirectoryManager dm;

    static Group group1, group2, group3;
    static Person thierry, didier, valentine;
    static User userThierry, userDidier, userValentine;

    @BeforeAll
    public static void init() {
        group1 = new Group("Groupe 1");
        group2 = new Group("Groupe 2");
        group3 = new Group("Groupe 3");

        valentine = new Person("Tirroir", "Valentine", new Date(90, Calendar.MARCH, 25), "valentine.tirroir@etu.univ-amu.fr", "https://www.sitewebvalentine.com", "valentine123");
        didier = new Person("Deschamps", "Didier", new Date(73, Calendar.APRIL, 28), "didier.deschamps@hotmail.fr", null, "dudul123");
        thierry = new Person("Bourdon", "Thierry", new Date(70, Calendar.DECEMBER, 12), "thierry.bourdon@hotmail.fr", null, "bourdon765");

        userThierry = new User(thierry.getEmail(), thierry.getPassword(), Set.of("USER"));
        userDidier = new User(didier.getEmail(), didier.getPassword(), Set.of("USER"));
        userValentine = new User(valentine.getEmail(), valentine.getPassword(), Set.of("USER"));

    }

    @Test
    public void testUserRepositoryFindByNameLike() {

        User expected = userThierry;

        dm.saveUser(userThierry);
        dm.saveUser(userDidier);
        dm.saveUser(userValentine);

        User result = (User) dao.findByStringProperty(User.class, "userName", "thierry.bourdon@hotmail.fr");

        System.out.println(userThierry.getUserName() + " " + result.getUserName());

        assertTrue(expected.equals(result));
    }

   /* @Test
    public void testGroupRepositoryFindByNameLike() {
        dao.saveGroup(group1);
        dao.saveGroup(group2);
        dao.saveGroup(group3);

        Group expected = group1;

        Group result = groupRepository.findByNameLike("Groupe 1");

        assertTrue(expected.equals(result));
    } */

  /*  @Test
    public void testPersonRepositoryFindByEmailLike() {
        dao.saveGroup(group1);
        dao.saveGroup(group2);
        valentine.setOwnGroup(group1);
        thierry.setOwnGroup(group1);
        didier.setOwnGroup(group2);
        dao.savePerson(valentine);
        dao.savePerson(thierry);
        dao.savePerson(didier);

        List<Person> expected = new ArrayList<>();
        expected.add(didier);
        expected.add(thierry);

        List<Person> results = personRepository.findByEmailLike("%hotmail.fr");

        int result = 0;

        for (Person p : expected) {
            for (Person per : results) {
                if (p.equals(per)) result++;
            }
        }
        assertEquals(result, 2);
    }

    @Test
    public void testPersonRepositoryFindPersonByEmailLike() {
        dao.saveGroup(group1);
        dao.saveGroup(group2);
        valentine.setOwnGroup(group1);
        thierry.setOwnGroup(group1);
        didier.setOwnGroup(group2);
        dao.savePerson(valentine);
        dao.savePerson(thierry);
        dao.savePerson(didier);

        Person expected = valentine;
        Person result = personRepository.findPersonByEmailLike("valentine.tirroir@etu.univ-amu.fr");

        assertTrue(expected.equals(result));
    }

    @Test
    public void testPersonRepositoryFindByFirstNameLike() {
        dao.saveGroup(group1);
        dao.saveGroup(group2);
        valentine.setOwnGroup(group1);
        thierry.setOwnGroup(group1);
        didier.setOwnGroup(group2);
        dao.savePerson(valentine);
        dao.savePerson(thierry);
        dao.savePerson(didier);

        List<Person> result = personRepository.findByFirstNameLike("Thierry");

        assertTrue(result.get(0).equals(thierry));
    }

    @Test
    public void testPersonRepositoryFindByLastNameLike() {
        dao.saveGroup(group1);
        dao.saveGroup(group2);
        valentine.setOwnGroup(group1);
        thierry.setOwnGroup(group1);
        didier.setOwnGroup(group2);
        dao.savePerson(valentine);
        dao.savePerson(thierry);
        dao.savePerson(didier);

        List<Person> result = personRepository.findByLastNameLike("Deschamps");

        assertTrue(result.get(0).equals(didier));
    }*/

}
