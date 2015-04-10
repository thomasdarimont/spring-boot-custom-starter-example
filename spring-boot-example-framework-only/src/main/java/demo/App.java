package demo;

import hello.HelloService;
import hello.HelloServiceAutoConfiguration;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args).getBean(HelloService.class).sayHello();
	}

	/**
	 * Replaces the default HelloService provided by {@link HelloServiceAutoConfiguration}.
	 */
	@Bean
	public HelloService customHelloServices() {
		return () -> Logger.getAnonymousLogger().info("Hello from Logger!");
	}
}
