package mybootapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller()
@RequestMapping("/user")
public class UserController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired()
    User user;
    
    @ModelAttribute("user")
    public User newUser() {
        return user;
    }

    @RequestMapping(value = "/show")
    public String show() {
        logger.info("show user " + user);
        return "user";
    }

    @RequestMapping(value = "/login")
    public String login() {
        logger.info("login user " + user);
        user.setName("It's me");
        return "user";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        logger.info("logout user " + user);
        user.setName("Anonymous");
        return "user";
    }
}