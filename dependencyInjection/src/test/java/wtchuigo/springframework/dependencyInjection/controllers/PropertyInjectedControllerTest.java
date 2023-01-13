/**
 * 
 */
package wtchuigo.springframework.dependencyInjection.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wtchuigo.springframework.dependencyInjection.services.ConstructorGreetingService;

/**
 * @author Tchuigoua
 *
 */
class PropertyInjectedControllerTest {
	
	PropertyInjectedController controller;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		controller = new PropertyInjectedController();
		
		controller.greetingService = new ConstructorGreetingService();
	}
	
	@Test
	void getGreeting() {
		System.out.println(controller.getGreeting());
	}

}
