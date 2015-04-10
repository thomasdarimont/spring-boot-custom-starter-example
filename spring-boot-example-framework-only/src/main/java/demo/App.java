package demo;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);

		ctx.getBean(HelloService.class).sayHello();
	}
	
	@Bean
	public HelloService helloService() {
		return () -> Logger.getAnonymousLogger().info("Hello from Logger!");
	}
	
//	@Bean
//	public HelloService foo() { // this fails as the bean needs to be named helloService as in
//															// demo.HelloServiceAutoConfiguration
//		return () -> Logger.getAnonymousLogger().info("Hello from Logger!");
//	}

}
