package com.example.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationController {

//	@GetMapping(value="/hello-world")
//	public String helloWorld() {
//		return "Hello World";
//	}
	
	@GetMapping(value="/basicauth")
	public AuthenticationBean helloWorldBean() {
		//throw new RuntimeException("Some error occurred");
		return new AuthenticationBean("You are authenticated ");
	}
	
//	@GetMapping(value="/hello-world-bean/path-variable/{name}")
//	public HelloWorldBean helloWorldBeanWithParavariable(@PathVariable String name) {
//		return new HelloWorldBean("Hello World "+ name);
//	}
}
