package mybootapp.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/secure")
public class SecureController {

    @Autowired
    SecureService ss;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return ss.helloAdmin();
    }

    @ResponseBody
    @RequestMapping("/aaa")
    public String helloForUser() {
        return ss.helloForUser("aaa");
    }

    @ResponseBody
    @RequestMapping("/code")
    public String helloSecureCode() {
        return ss.helloSecuredByCode();
    }

    
}