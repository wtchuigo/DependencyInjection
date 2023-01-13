package wtchuigo.springframework.dependencyInjection.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import wtchuigo.springframework.dependencyInjection.services.GreetingService;

@Controller
public class I18nController {
	
	/**
	 * @param greetingService
	 */
	public I18nController(@Qualifier("i18nService") GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	private GreetingService greetingService;
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}

}
