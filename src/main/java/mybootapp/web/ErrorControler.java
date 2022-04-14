package mybootapp.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorControler implements ErrorController {

    @ResponseBody
    @ExceptionHandler({NullPointerException.class})
    public String handleNullPointerException(Exception e) {
        System.err.println("-- NullPointerException:");
        e.printStackTrace(System.err);
        return "Null Pointer Error";
    }

    @ResponseBody
    @ExceptionHandler
    public String handleOtherException(Exception e) {
        System.err.println("-- Other Exception:");
        e.printStackTrace(System.err);
        return "Other Error";
    }

}