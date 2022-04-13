package mybootapp.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mybootapp.model.SimpleUser;

@Controller()
@RequestMapping("/simple-user")
@SessionAttributes("simpleUser")
public class SimpleUserController {

    protected final Log logger = LogFactory.getLog(getClass());

    @ModelAttribute("simpleUser")
    public SimpleUser newUser() {
        var user = new SimpleUser();
        logger.info("new user " + user);
        return user;
    }

    @RequestMapping(value = "/show")
    public String show(@ModelAttribute("simpleUser") SimpleUser user) {
        logger.info("show user " + user);
        return "simple-user";
    }

    @RequestMapping(value = "/login")
    public String login(//
            @ModelAttribute("simpleUser") SimpleUser user, //
            RedirectAttributes attributes) {
        logger.info("login user " + user);
        user.setName("It's me");
        attributes.addFlashAttribute("message", "Bienvenue !");
        return "redirect:show";
    }

    @RequestMapping(value = "/logout")
    public String logout(//
            @ModelAttribute("simpleUser") SimpleUser user, //
            RedirectAttributes attributes) {
        logger.info("logout user " + user);
        user.setName("Anonymous");
        attributes.addFlashAttribute("message", "Au revoir.");
        return "redirect:show";
    }
}