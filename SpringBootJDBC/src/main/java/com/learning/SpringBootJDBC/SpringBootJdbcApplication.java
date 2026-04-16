package com.learning.SpringBootJDBC;

import com.learning.SpringBootJDBC.model.Alien;
import com.learning.SpringBootJDBC.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);

		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(106);
		alien1.setName("Riya");
		alien1.setTech("Java");

		AlienRepo alienRepo = context.getBean(AlienRepo.class);
		alienRepo.save(alien1);
		for (Alien alien : alienRepo.findAll()) {
			System.out.println(alien);
		}

	}

}
