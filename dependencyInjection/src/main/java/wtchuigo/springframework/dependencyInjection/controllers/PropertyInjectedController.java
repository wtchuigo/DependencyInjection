/**
 * 
 */
package wtchuigo.springframework.dependencyInjection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import wtchuigo.springframework.dependencyInjection.services.GreetingService;

/**
 * @author Tchuigoua
 *
 */
@Controller
public class PropertyInjectedController {
	
	@Qualifier("propertyInjectedGreetingService")
	@Autowired
	public GreetingService greetingService;
	
	public String getGreeting() {
		return greetingService.sayGreeting();		
	}

}
