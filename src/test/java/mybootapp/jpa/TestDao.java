package mybootapp.jpa;


import mybootapp.dao.Dao;
import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.web.Starter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Dao.class)
@ContextConfiguration(classes = Starter.class)
public class TestDao {

    @Autowired
    Dao dao;

    static Group group1, group2, group3;
    static Person thierry, didier, valentine;

    @SuppressWarnings("deprecation")

    @BeforeAll
    public static void init() {

        group1 = new Group("Groupe 1");
        group2 = new Group("Groupe 2");
        group3 = new Group("Groupe 3");

        valentine = new Person("Tirroir", "Valentine", new Date(1980, Calendar.MARCH, 25), "valentine.tirroir@etu.univ-amu.fr", "https://www.sitewebvalentine.com", "valentine123");
        didier = new Person("Deschamps", "Didier", new Date(1973, Calendar.APRIL, 28), "didier.deschamps@hotmail.fr", null, "dudul123");
        thierry = new Person("Bourdon", "Thierry", new Date(1970, Calendar.DECEMBER, 12), "thierry.bourdon@hotmail.fr", null, "bourdon765");

    }


    @Test
    public void testSaveAndFind() {

        dao.saveGroup(group1);
        dao.saveGroup(group2);
        didier.setOwnGroup(group1);
        thierry.setOwnGroup(group2);
        dao.savePerson(didier);
        dao.savePerson(thierry);

        Person resultPerson = dao.findPerson(3);
        Group resultGroup = dao.findGroup(1);
        assertTrue(thierry.equals(resultPerson));
        assertEquals(group1.getName(), resultGroup.getName());
    }


    @Test
    public void testSaveAndFindAll() {

        List<Person> persons = (List<Person>) dao.findAll(Person.class);
        List<Group> groups = (List<Group>) dao.findAll(Group.class);

        boolean resultPerson = true;
        boolean resultGroup = true;

        if (!persons.get(0).equals(didier)) resultPerson = false;
        if (!persons.get(1).equals(thierry)) resultPerson = false;

        if (!groups.get(0).getName().equals(group1.getName())) resultGroup = false;
        if (!groups.get(1).getName().equals(group2.getName())) resultGroup = false;

        assertTrue(resultPerson);
        assertTrue(resultGroup);
    }

    @Test
    public void testRemove() {

        dao.saveGroup(group3);

        dao.remove(Person.class, (long) 3);
        dao.remove(Group.class, (long) 3);

        Person afterRemovePerson = dao.findPerson(3);
        Group afterRemoveGroup = dao.findGroup(3);

        assertNull(afterRemovePerson);
        assertNull(afterRemoveGroup);
    }

}
