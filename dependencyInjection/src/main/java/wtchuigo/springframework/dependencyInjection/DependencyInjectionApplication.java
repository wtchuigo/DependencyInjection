package wtchuigo.springframework.dependencyInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import wtchuigo.springframework.dependencyInjection.config.SfgConfiguration;
import wtchuigo.springframework.dependencyInjection.config.SfgConstructorConfig;
import wtchuigo.springframework.dependencyInjection.controllers.ConstructorInjectedController;
import wtchuigo.springframework.dependencyInjection.controllers.I18nController;
import wtchuigo.springframework.dependencyInjection.controllers.MyController;
import wtchuigo.springframework.dependencyInjection.controllers.PetController;
import wtchuigo.springframework.dependencyInjection.controllers.PropertyInjectedController;
import wtchuigo.springframework.dependencyInjection.controllers.SetterInjectedController;
import wtchuigo.springframework.dependencyInjection.datasource.FakeDataSource;
import wtchuigo.springframework.dependencyInjection.service.PrototypeBean;
import wtchuigo.springframework.dependencyInjection.service.SingletonBean;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);
		
		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());
		
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());
		
		MyController myController = (MyController) ctx.getBean("myController");
		
		System.out.println("-----------Primary Bean");		
		System.out.println(myController.sayHello());
		
		System.out.println("-----------Property");		
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");		
		System.out.println(propertyInjectedController.getGreeting());
		
		System.out.println("-----------Setter");		
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");		
		System.out.println(setterInjectedController.getGreeting());
		
		System.out.println("-----------Constructor");		
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");		
		System.out.println(constructorInjectedController.getGreeting());
		
		System.out.println("-----------Bean Scope -------");	
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());		
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());
		
		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());
		
		System.out.println("-----Fake Datasource Bean");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());
		
		System.out.println("-----config Props Bean");
		SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
		System.out.println(sfgConfiguration.getUsername());
		System.out.println(sfgConfiguration.getPassword());
		System.out.println(sfgConfiguration.getJdbcurl());
		
		System.out.println("-----Constructor Binding");
		SfgConstructorConfig sfgConstructorConfig = ctx.getBean(SfgConstructorConfig.class);
		System.out.println(sfgConstructorConfig.getUsername());
		System.out.println(sfgConstructorConfig.getPassword());
		System.out.println(sfgConstructorConfig.getJdbcurl());
		
	}

}
