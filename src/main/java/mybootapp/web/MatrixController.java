package mybootapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/tests")
public class MatrixController {

	@RequestMapping(value = "/matrix/{param}", method = RequestMethod.GET)
	@ResponseBody
	public String testMatrix(//
	        @PathVariable("param") String param, //
	        @MatrixVariable(name = "a", defaultValue = "A") String a, //
	        @MatrixVariable(name = "b", defaultValue = "1") Integer b//
	) {
	    return String.format("param=%s, a=%s, b=%d", param, a, b);
	}
	
}
