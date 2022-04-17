package mybootapp.web;

import com.github.javafaker.Faker;
import mybootapp.dao.Dao;
import mybootapp.manager.DirectoryManager;
import mybootapp.manager.IDirectoryManager;
import mybootapp.model.Group;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;
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
@ComponentScan(basePackageClasses = {DirectoryManager.class, Dao.class})
@RequestMapping("/group")
public class GroupController {

	@Autowired
	IDirectoryManager dm;

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
			dm.saveGroup(group);
		}
	}

	@RequestMapping(" ")
	public ModelAndView listGroups() {
		return new ModelAndView("group", "groups", dm.findAllGroups());
	}

	@RequestMapping("/new")
	public String newGroup() {
		final var group = new Group(String.format("Groupe %d", dm.count()+1));
		dm.saveGroup(group);
		return "redirect:/group";
	}


	@RequestMapping("/find")
	public ModelAndView findGroups(String name) {
		final var result = dm.findByStringProperty(Group.class, "name", "%"+name+"%");
		//final var result = repo.findByNameLike("%" + name + "%");
		return new ModelAndView("group", "groups", result);
	}


	@ModelAttribute("searchGroups")
	public Map<Long, String> searchGroups() {
		Map<Long, String> groupResult = new LinkedHashMap<>();
		ArrayList<Group> groups = new ArrayList<>(dm.findAllGroups());
		for(Group group : groups){
			groupResult.put(group.getId(), group.getName());
		}
		return groupResult;
	}
}
