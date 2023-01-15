package wtchuigo.springframework.dependencyInjection.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("DE")
@Service("i18nService")
public class I18nGermanGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello Welt - DE";
	}

}
