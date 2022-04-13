package mybootapp.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/tests")
public class HelloAnnoController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView sayHello() {
        String now =(new Date()).toString();
        logger.info("Running " + this);
        return new ModelAndView("hello", "now", now);
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public ModelAndView datePrint(
    		@RequestParam(value="now", defaultValue = "2000-02-10")@DateTimeFormat(pattern="yyyy-MM-dd") Date value) {
        logger.info("Running plus10 controler with param = "+ value.toString());
        return new ModelAndView("hello", "now", value);
    }
    
    @RequestMapping(value = "/voir/{param}/{option}", method = RequestMethod.GET)
    public ModelAndView voir(@PathVariable("param") Integer param, @PathVariable("option") String option) {
        logger.info("Running param controler with param=" + param);
        
        Map<String,Object> map = new HashMap<>();
        map.put("now", param);
        map.put("message", option);
        return new ModelAndView("hello", map);
    }
    
}