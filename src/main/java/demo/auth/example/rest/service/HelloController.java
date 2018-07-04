package demo.auth.example.rest.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.auth.example.config.security.annotation.IsAdmin;
import demo.auth.example.config.security.annotation.IsUser;

/**
 * This controller contains the endpoints where you have to be logged in in and authorized.
 */
@RestController
public class HelloController {

	//TODO: For session looks here http://docs.spring.io/spring-session/docs/current/reference/html5/#httpsession-rest

	@IsAdmin
	@RequestMapping(path = "/hello/admin", method = RequestMethod.GET)
	public String sayHelloToTheAdmin() {
		return "Hello Admin!";
	}

	@IsUser
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello World!";
	}

}
