package wtchuigo.springframework.dependencyInjection.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import wtchuigo.springframework.dependencyInjection.datasource.FakeDataSource;
import wtchuigo.springframework.dependencyInjection.repositories.EnglishGreetingRepository;
import wtchuigo.springframework.dependencyInjection.repositories.EnglishGreetingRepositoryImpl;
import wtchuigo.springframework.dependencyInjection.service.ConstructorGreetingService;
import wtchuigo.springframework.dependencyInjection.service.I18nEnglishGreetingService;
import wtchuigo.springframework.dependencyInjection.service.I18nGermanGreetingService;
import wtchuigo.springframework.dependencyInjection.service.PrimaryGreetingService;
import wtchuigo.springframework.dependencyInjection.service.PropertyInjectedGreetingService;
import wtchuigo.springframework.dependencyInjection.service.SetterInjectedGreetingService;
import wtchuigo.springframework.pets.PetService;
import wtchuigo.springframework.pets.PetServiceFactory;

@EnableConfigurationProperties(SfgConstructorConfig.class)
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {
	
	@Bean
	FakeDataSource fakeDataSource(SfgConstructorConfig sfgConstructorConfig) {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUsername(sfgConstructorConfig.getUsername());
		fakeDataSource.setPassword(sfgConstructorConfig.getPassword());
		fakeDataSource.setJdbcurl(sfgConstructorConfig.getJdbcurl());
		return fakeDataSource;
	}
	
	@Bean
	PetServiceFactory petServiceFactory() {
		return new PetServiceFactory();
	}
	
	@Profile({"dog", "default"})
	@Bean()
	PetService dogPetService(PetServiceFactory petServiceFactory) {
		return petServiceFactory.getPetService("dog");		
	}
	
	@Profile("cat")
	@Bean
	PetService catPetService(PetServiceFactory petServiceFactory) {
		return petServiceFactory.getPetService("cat");
	}
	
	@Profile("DE")
	@Bean("i18nService")
	I18nGermanGreetingService i18nGermanGreetingService() {
		return new I18nGermanGreetingService();
	}
	
	@Bean
	EnglishGreetingRepository englishGreetingRepository() {
		return new EnglishGreetingRepositoryImpl();
	}
	
	@Profile("EN")
	@Bean
	I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
		return new I18nEnglishGreetingService(englishGreetingRepository);
	}
	
	@Primary
	@Bean
	PrimaryGreetingService primaryGreetingService() {
		return new PrimaryGreetingService();
	}

//	@Bean
	ConstructorGreetingService constructorGreetingService() {
		return new ConstructorGreetingService();
	}

	@Bean
	PropertyInjectedGreetingService propertyInjectedGreetingService() {
		return new PropertyInjectedGreetingService();
	}

	@Bean
	SetterInjectedGreetingService setterInjectedGreetingService() {
		return new SetterInjectedGreetingService();
	}

}
