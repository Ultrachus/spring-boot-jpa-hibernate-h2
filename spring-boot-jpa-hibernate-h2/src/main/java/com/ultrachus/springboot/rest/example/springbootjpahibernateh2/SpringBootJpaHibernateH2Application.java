package com.ultrachus.springboot.rest.example.springbootjpahibernateh2;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJpaHibernateH2Application {

	private static final Logger log = LoggerFactory.getLogger(SpringBootJpaHibernateH2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaHibernateH2Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			log.debug("Vamos a inspeccionar los beans que Spring Boot ha proporcionado:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				log.debug(beanName);
			}
		};
	}

}
