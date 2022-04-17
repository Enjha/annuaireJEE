package mybootapp.jpa;


import mybootapp.dao.Dao;
import mybootapp.dao.IDao;
import mybootapp.dao.SpringConfiguration;
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
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Dao.class)
@ContextConfiguration(classes = Starter.class)
public class TestDao {

    @Autowired
    IDao dao;

    static Group group1, group2, group3;
    static Person thierry, didier, valentine,toto, titi;


    @BeforeAll
    public static void init() {

        group1 = new Group("Groupe 1");
        group2 = new Group("Groupe 2");
        group3 = new Group("Groupe 3");

        valentine = new Person("Tirroir", "Valentine", new Date(90, Calendar.MARCH, 25), "valentine.tirroir@etu.univ-amu.fr", "https://www.sitewebvalentine.com", "valentine123");
        didier = new Person("Deschamps", "Didier", new Date(73, Calendar.APRIL, 28), "didier.deschamps@hotmail.fr", null, "dudul123");
        thierry = new Person("Bourdon", "Thierry", new Date(70, Calendar.DECEMBER, 12), "thierry.bourdon@hotmail.fr", null, "bourdon765");

        toto = new Person("Tata", "toto", new Date(73, Calendar.APRIL, 28), "toto.tata@hotmail.fr", null, "toto984298");
        titi = new Person("Tata", "titi", new Date(73, Calendar.APRIL, 28), "titi.tata@hotmail.fr", null, "titi478473");

    }

    @Test
    public void testFindOneByStringProperty() {
        Person person = dao.findOneByStringProperty(Person.class,"lastName","test");
        assertEquals("test@gmail.com", person.getEmail());
    }

    @Test
    public void testAdd(){
        dao.add(group1);
        valentine.setOwnGroup(group1);
        dao.add(valentine);
        Person personResult = dao.findOneByStringProperty(Person.class,"email","valentine.tirroir@etu.univ-amu.fr");
        Group groupResult = dao.findOneByStringProperty(Group.class,"name","Groupe 1");
        assertEquals(valentine.getEmail(),personResult.getEmail());
        assertEquals(group1.getName(),groupResult.getName());
    }

    @Test
    public void testFind() {
        dao.add(group2);
        thierry.setOwnGroup(group2);
        dao.add(thierry);

        Person resultPerson = dao.find(Person.class, thierry.getId());
        Group resultGroup = dao.find(Group.class, thierry.getOwnGroup().getId());

        assertNotNull(resultPerson);
        assertNotNull(resultGroup);
    }


    @Test
    public void testUpdate(){
        thierry.setOwnGroup(group1);
        dao.update(thierry);
        assertEquals(thierry.getOwnGroup().getName(),"Groupe 1");
    }

    @Test
    public void testFindByStringProperty(){
        dao.add(group3);
        toto.setOwnGroup(group3);
        titi.setOwnGroup(group3);

        dao.add(toto);
        dao.add(titi);

        List<Person> titiAndtoto = (List<Person>) dao.findByStringProperty(Person.class,"lastName","Tata");

        assertTrue((titiAndtoto.get(0).equals(toto) && titiAndtoto.get(1).equals(titi) ||(titiAndtoto.get(1).equals(toto) && titiAndtoto.get(0).equals(titi))));
    }
}
