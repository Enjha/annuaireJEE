package mybootapp.web;

import java.util.Stack;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class RestCalculator {

    protected final Log logger = LogFactory.getLog(getClass());
    private Stack<Integer> numbers = new Stack<>();

    @PostConstruct
    public void init() {
        numbers.push(100);
        numbers.push(200);
        numbers.push(300);
    }

    @GetMapping("/show")
    public Stack<Integer> show() {
        return numbers;
    }

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void add() {
        Integer val1 = numbers.pop();
        Integer val2 = numbers.pop();
        numbers.push(val1 + val2);
    }

    @GetMapping("/sub")
    @ResponseStatus(HttpStatus.OK)
    public void sub() {
        Integer val1 = numbers.pop();
        Integer val2 = numbers.pop();
        numbers.push(val1 - val2);
    }
    
    @PostMapping(value = "/put", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String put(@RequestBody() Integer id) {
        numbers.push(id);
        logger.info(String.format("put %d", id));
        return "Ok";
    }

}