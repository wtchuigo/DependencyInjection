package wtchuigo.springframework.dependencyInjection.service;

public class I18nGermanGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello Welt - DE";
	}

}
