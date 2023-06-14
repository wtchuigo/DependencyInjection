package wtchuigo.springframework.dependencyInjection.service;

public class SetterInjectedGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World - Setter";
	}

}
