package mybootapp.web;

import java.security.Principal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/principal")
public class ShowPrincipal {

    protected final Log logger = LogFactory.getLog(getClass());

    @ResponseBody
    @RequestMapping("")
    public String show(Principal p) {
        logger.info("show user " + p);
        return p.toString();
    }

}