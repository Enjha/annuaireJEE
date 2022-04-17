package mybootapp.web;

import com.github.javafaker.Faker;
import mybootapp.manager.IDirectoryManager;
import mybootapp.model.Group;
import mybootapp.model.Person;
import mybootapp.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.*;

@Controller
@ContextConfiguration(classes = Starter.class)
@RequestMapping("/person")
public class PersonController {

    @Autowired
    IDirectoryManager dm;

    protected final Log logger = LogFactory.getLog(getClass());

    @ModelAttribute("persons")
    Collection<Person> persons() {
        logger.info("Making list of persons");
        return dm.findAllPersons();
    }

    @PostConstruct
    public void init() {
        Date date = new Date(95, Calendar.JUNE, 20);
        Person p = new Person("test", "test", date, "test@gmail.com","" , "testPourTest");
        Random r = new Random();
        int rInteger = 1 + r.nextInt(100);
        p.setOwnGroup(dm.findGroup(rInteger));
        dm.savePerson(p);
        Faker faker = new Faker();
        for(int i= 0;i<1000;i++){
            String fakeFirstName = faker.name().firstName();
            String fakeLastName = faker.name().lastName();
            Date fakeBirthDay = faker.date().birthday();
            String fakeEmail = faker.internet().emailAddress();
            String fakeWebSite = faker.internet().domainName();
            String fakePassword = faker.internet().password();

            fakeWebSite = "https://"+fakeWebSite+".com";
            Person person = new Person(fakeLastName, fakeFirstName, fakeBirthDay, fakeEmail, fakeWebSite, fakePassword);

            Random random = new Random();
            int randomInteger = 1 + random.nextInt(100);
            person.setOwnGroup(dm.findGroup(randomInteger));
            dm.savePerson(person);
        }
    }

    @RequestMapping(value = " ", method = RequestMethod.GET)
    public ModelAndView listPersons() {
        logger.info("List of persons");
        Collection<Person> persons = dm.findAllPersons();
        return new ModelAndView("personsList", "persons", persons);
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPerson(@ModelAttribute Person p) {
        ArrayList<String> result = new ArrayList<>();
        for (Object o :  SecurityContextHolder.getContext().getAuthentication().getAuthorities()){
            result.add(o.toString());
        }
        System.out.println(result);
        if( dm.isConnectedAs(p) || result.contains("ADMIN"))
            return "personForm";
        else{
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/personNew", method = RequestMethod.GET)
    public String newPerson() { return "personNewForm"; }

    @ModelAttribute
    public Person newPerson(
            @RequestParam(value = "id", required = false) Long id)
    {
        if (id != null) {
            logger.info("find person " + id);
            return dm.findPerson(id);
        }
        Person p = new Person();
        p.setLastName("");
        p.setFirstName("");
        p.setBirthDay(new Date());
        p.setEmail("");
        p.setWebsite("");
        p.setPassword("");
        logger.info("new person = " + p);
        return p ;
    }
    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    PersonValidator validator;


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditPerson(@ModelAttribute @Valid Person p, BindingResult result) {
        validator.validate(p, result);
        if (result.hasErrors()) {
            return "personForm";
        }
        var encoder = passwordEncoder();
        var user = new User(p.getEmail(), encoder.encode(p.getPassword()), Set.of("USER"));
        dm.saveUser(user);
        dm.savePerson(p);
        return "redirect:/person/";
    }

    @RequestMapping(value = "/personNew", method = RequestMethod.POST)
    public String saveNewPerson(@ModelAttribute @Valid Person p, BindingResult result) {
        validator.validate(p, result);
        if (result.hasErrors()) {
            return "personNewForm";
        }
        var encoder = passwordEncoder();
        var user = new User(p.getEmail(), encoder.encode(p.getPassword()), Set.of("USER"));
        dm.saveUser(user);
        dm.savePerson(p);
        return "redirect:/person/";
    }

    @ModelAttribute("personGroup")
    public Map<Long, String> personGroups() {
        Map<Long, String> groupResult = new LinkedHashMap<>();
        ArrayList<Group> groups = new ArrayList<>(dm.findAllGroups());
        for(Group group : groups){
            groupResult.put(group.getId(), group.getName());
        }
        return groupResult;
    }

    // controleur d'affichage d'une personne
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showPerson(@ModelAttribute Person p, final RedirectAttributes redirAtt) {
        if (p == null) {
            redirAtt.addFlashAttribute("errorPersonId", true);
            return "redirect:/actions/user/home";
        }
        else if (p.getEmail().equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
            return "redirect:edit?id="+p.getId();
        }
        return "personShow";
    }

    @RequestMapping("/find")
    public ModelAndView findPersons(String name) {
        final var result = dm.findByStringProperty(Person.class, "email", "%"+name+"%");
        final var result1 = dm.findByStringProperty(Person.class, "lastName", "%"+name+"%");
        final var result2 = dm.findByStringProperty(Person.class, "firstName", "%"+name+"%");
        if (!result.containsAll(result1)){
            result.addAll(result1);
        }if (!result.containsAll(result2)){
            result.addAll(result2);
        }
        return new ModelAndView("personsList", "persons", result);
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String editPassword() {
        return "forgotPassword";
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public String saveEditPassword(@ModelAttribute Person p) {
        var encoder = passwordEncoder();
        Person person = dm.findOneByStringProperty(Person.class, "email", p.getEmail());
        int DateADay = p.getBirthDay().getDay();
        int DateAMonth = p.getBirthDay().getMonth();
        int DateAYear = p.getBirthDay().getYear();
        int DateBDay = person.getBirthDay().getDay();
        int DateBMonth = person.getBirthDay().getMonth();
        int DateBYear = person.getBirthDay().getYear();
        if(person == null) {
            System.out.println("Email n'existe pas");
            return "redirect:/";
        }if((DateADay != DateBDay) && (DateAMonth != DateBMonth) && (DateAYear != DateBYear)){
            System.out.println("Date de naissance incorrecte");
            return "redirect:/";
        }
        person.setPassword(p.getPassword());
        person.setEmail(p.getEmail());
        person.setBirthDay(p.getBirthDay());
        var user = dm.findOneByStringProperty(User.class, "userName", p.getEmail());
        user.setPassword(encoder.encode(p.getPassword()));
        dm.saveUser(user);
        dm.savePerson(person);
        return "/passwordChanged";
    }
}