package mybootapp;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import mybootapp.model.Group;
import mybootapp.model.XUser;
import mybootapp.repo.GroupRepository;
import mybootapp.repo.XUserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import mybootapp.model.Person;
import mybootapp.repo.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonRepository repo;

    @Autowired
    GroupRepository GroupRepo;

    @Autowired
    XUserRepository userRepo;

    protected final Log logger = LogFactory.getLog(getClass());

    @ModelAttribute("persons")
    Collection<Person> persons() {
        logger.info("Making list of persons");
        return repo.findAll();
    }

    @SuppressWarnings("deprecation")
    @PostConstruct
    public void init() {
        Group group1 = new Group("creation");
        Person p1 = new Person("Bourdon", "Thierry", new Date(1970, Calendar.DECEMBER, 12), "thierry.bourdon@hotmail.fr", null, "bourdon765");
        Person p2 = new Person("Deschamps", "Didier", new Date(1973, Calendar.APRIL, 28), "didier.deschamps@hotmail.fr", null, "dudul123");

        p1.setOwnGroup(GroupRepo.getById(1L));
        p2.setOwnGroup(GroupRepo.getById(2L));

        repo.save(p1);
        repo.save(p2);
    }

    @RequestMapping(value = " ", method = RequestMethod.GET)
    public ModelAndView listPersons() {
        logger.info("List of persons");
        Collection<Person> persons = repo.findAll();
        return new ModelAndView("personsList", "persons", persons);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPerson(@ModelAttribute Person p) {
        return "personForm";
    }

    @ModelAttribute
    public Person newPerson(
            @RequestParam(value = "id", required = false) Long id)
    {
        if (id != null) {
            logger.info("find person " + id);
            var p = repo.findById(id);
            return p.get();
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
    public String savePerson(@ModelAttribute @Valid Person p, BindingResult result) {
        validator.validate(p, result);
        if (result.hasErrors()) {
            return "personForm";
        }
        var encoder = passwordEncoder();
        var user = new XUser(p.getEmail(), encoder.encode(p.getPassword()), Set.of("USER"));
        userRepo.save(user);
        repo.save(p);
        return "redirect:/person/";
    }


    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showPerson(@ModelAttribute Person p) {
        return "personShow";
    }

    @ModelAttribute("personGroup")
    public Map<Long, String> personGroups() {
        Map<Long, String> groupResult = new LinkedHashMap<>();
        ArrayList<Group> groups = new ArrayList<>(GroupRepo.findAll());
        for(Group group : groups){
            groupResult.put(group.getId(), group.getName());
        }
        return groupResult;
    }

    @RequestMapping("/find")
    public ModelAndView findPersons(String name) {
        final var result = repo.findByEmailLike("%" + name + "%");
        final var result1 = repo.findByLastNameLike("%" + name + "%");
        final var result2 = repo.findByFirstNameLike("%" + name + "%");
        if (!result.containsAll(result1)){
            result.addAll(result1);
        }if (!result.containsAll(result2)){
            result.addAll(result2);
        }
        return new ModelAndView("personsList", "persons", result);
    }
}