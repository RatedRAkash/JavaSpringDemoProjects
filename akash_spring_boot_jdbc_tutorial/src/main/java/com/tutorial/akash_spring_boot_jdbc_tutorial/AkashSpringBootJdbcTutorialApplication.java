package com.tutorial.akash_spring_boot_jdbc_tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AkashSpringBootJdbcTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkashSpringBootJdbcTutorialApplication.class, args);

		//TODO: in Spring-JDBC [Repository === DAO]... that means we use DAO(Data Access Objects) instead of Repository
	}

}
