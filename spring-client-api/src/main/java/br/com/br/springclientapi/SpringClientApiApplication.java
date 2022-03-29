package br.com.br.springclientapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringClientApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringClientApiApplication.class, args);
	}

}
