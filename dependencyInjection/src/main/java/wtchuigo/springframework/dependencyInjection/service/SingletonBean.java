package wtchuigo.springframework.dependencyInjection.service;

import org.springframework.stereotype.Component;

//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class SingletonBean {

	public SingletonBean() {
		System.out.println("Creating a Singleton Bean!!!!!!!!!!!!!!");
	}
	
	public String getMyScope() {
		return "I´m a Singleton";
	}
}
