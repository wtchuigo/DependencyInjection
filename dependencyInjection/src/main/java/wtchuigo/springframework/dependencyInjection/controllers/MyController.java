/**
 * 
 */
package wtchuigo.springframework.dependencyInjection.controllers;

import org.springframework.stereotype.Controller;

import wtchuigo.springframework.dependencyInjection.service.GreetingService;

/**
 * @author Tchuigoua
 *
 */
@Controller
public class MyController {

	private final GreetingService greetingService;
	
	/**
	 * @param greetingService
	 */
	public MyController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}

}
