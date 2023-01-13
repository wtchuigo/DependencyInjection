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
class SetterInjectedControllerTest {
	
	SetterInjectedController controller;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		controller = new SetterInjectedController();
		controller.setGreetingService(new ConstructorGreetingService());
	}

	/**
	 * Test method for {@link wtchuigo.springframework.sfgdi.controllers.SetterInjectedController#getGreeting()}.
	 */
	@Test
	void testGetGreeting() {
		System.out.println(controller.getGreeting());
	}

}
