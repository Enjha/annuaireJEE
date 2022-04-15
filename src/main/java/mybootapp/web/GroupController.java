package mybootapp.web;

import com.github.javafaker.Faker;
import mybootapp.dao.Dao;
import mybootapp.model.Group;
import mybootapp.repo.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@ComponentScan(basePackageClasses = Dao.class)
@RequestMapping("/group")
public class GroupController {
	/*
	 * Injection de la DAO de manipulation des groupes.
	 */
	@Autowired
	GroupRepository repo;

	@Autowired
	GroupRepository groupRepo;

	@Autowired
	Dao dao;

	@PostConstruct
	public void init() {

		Faker faker = new Faker();
		ArrayList<String> listName = new ArrayList<>();
		for(int i=0;i < 100; i++){
			String fakeName = faker.team().name();
			if(listName.contains(fakeName)){
				while(listName.contains(fakeName)){
					fakeName = faker.team().name();
				}
			}
			Group group = new Group(fakeName);
			listName.add(fakeName);
			dao.saveGroup(group);
		}
	}

	@RequestMapping(" ")
	public ModelAndView listGroups() {
		return new ModelAndView("group", "groups", groupRepo.findAll());
	}

	@RequestMapping("/new")
	public String newGroup() {
		final var group = new Group(String.format("Groupe %d", repo.count()+1));
		dao.saveGroup(group);
		return "redirect:/group";
	}


	@RequestMapping("/find")
	public ModelAndView findGroups(String name) {
		final var result = repo.findByNameLike("%" + name + "%");
		return new ModelAndView("group", "groups", result);
	}


	@ModelAttribute("searchGroups")
	public Map<Long, String> searchGroups() {
		Map<Long, String> groupResult = new LinkedHashMap<>();
		ArrayList<Group> groups = new ArrayList<>(groupRepo.findAll());
		for(Group group : groups){
			groupResult.put(group.getId(), group.getName());
		}
		return groupResult;
	}
}
