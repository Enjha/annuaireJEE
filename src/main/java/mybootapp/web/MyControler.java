package mybootapp.web;

import mybootapp.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/")
public class MyControler {

	/*
	 * Récupérer un message particulier dans le fichier de configuration pour ne pas
	 * utiliser de constantes dans le code.
	 */
	@Value("${application.message:Ce site permet d'accéder à un annuaire de personnes}")
	private String message;

	/*
	 * Point d'entrée principal de l'application.
	 */
	@RequestMapping("")
	public ModelAndView index() {
		return new ModelAndView("index", "message", message);
	}


}
