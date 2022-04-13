package mybootapp.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Service("/hello")
public class HelloController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    
    
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Returning hello view");
        String now = (new Date()).toString();
        String message = "Vous etes sur la meilleur page du site !";
        Map<String, String> map = new HashMap<>();
        map.put("now", now);
        map.put("message", message);
        return new ModelAndView("hello", map);
    }
    
    
    
    @PostConstruct
	public void init() {
	}
}
