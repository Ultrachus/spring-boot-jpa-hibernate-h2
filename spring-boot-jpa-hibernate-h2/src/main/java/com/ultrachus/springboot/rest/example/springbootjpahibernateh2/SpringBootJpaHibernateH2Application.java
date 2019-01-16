package com.ultrachus.springboot.rest.example.springbootjpahibernateh2;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ultrachus.springboot.rest.example.springbootjpahibernateh2.entities.Student;
import com.ultrachus.springboot.rest.example.springbootjpahibernateh2.repositories.StudentRepository;

@SpringBootApplication
public class SpringBootJpaHibernateH2Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootJpaHibernateH2Application.class);

	@Autowired
	private StudentRepository studentRepository;

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

	@Override
	public void run(String... args) throws Exception {
		log.info("Student id 10001 -> {}", studentRepository.findById(10001L));

		log.info("All users 1 -> {}", studentRepository.findAll());

		// Insert
		log.info("Inserting -> {}", studentRepository.save(new Student("John", "A1234657")));

		// Update
		log.info("Update 10001 -> {}", studentRepository.save(new Student(10001L, "Name-Updated", "New-Passport")));

		studentRepository.deleteById(10002L);

		log.info("All users 2 -> {}", studentRepository.findAll());
	}

}
