package mybootapp.web;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import mybootapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mybootapp.model.Group;
import mybootapp.repo.GroupRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/group")
public class GroupController {

	/*
	 * Injection de la DAO de manipulation des groupes.
	 */
	@Autowired
	GroupRepository repo;

	@PostConstruct
	public void init() {
		Group group1 = new Group("Groupe 1");
		Group group2 = new Group("Groupe 2");
		repo.save(group1);
		repo.save(group2);
	}

	@RequestMapping(" ")
	public ModelAndView listGroups() {
		return new ModelAndView("group", "groups", repo.findAll());
	}

	@RequestMapping("/new")
	public String newGroup() {
		final var group = new Group(String.format("Groupe %d", repo.count()+1));
		repo.save(group);
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
		ArrayList<Group> groups = new ArrayList<>(repo.findAll());
		int i = 0;
		for(Group group : groups){
			groupResult.put(group.getId(), group.getName());
		}
		return groupResult;
	}
}
