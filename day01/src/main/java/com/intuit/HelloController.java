package com.intuit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


//http://localhost:8080/hello/Sam  -> Hi Sam
//http://localhost:8080/hello/Ram  -> Hi Ram

//http://localhost:8080/bye?name=Joe -> Bye Joe

@Controller
public class HelloController {
	
	@GetMapping("/hello/{name}")
	@ResponseBody
	public String greet(@PathVariable("name") String name) {
		return "Hi " + name;
	}
	
	@PostMapping("/bye")
	@ResponseBody
	public String bye(@RequestParam("name") String name) {
		return "Bye " + name;
	}
	
}
