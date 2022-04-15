package mybootapp.web.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";

    }

    @RequestMapping(value="/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";

    }
}
