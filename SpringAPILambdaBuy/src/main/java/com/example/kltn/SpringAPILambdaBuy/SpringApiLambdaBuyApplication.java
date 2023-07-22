
package com.example.kltn.SpringAPILambdaBuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.example.kltn.SpringAPILambdaBuy")
public class SpringApiLambdaBuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiLambdaBuyApplication.class, args);
	}
}
