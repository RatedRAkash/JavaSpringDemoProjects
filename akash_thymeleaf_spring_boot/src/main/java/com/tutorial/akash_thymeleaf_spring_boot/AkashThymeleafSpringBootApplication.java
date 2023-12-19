package com.tutorial.akash_thymeleaf_spring_boot;

import com.tutorial.akash_thymeleaf_spring_boot.entity.Student;
import com.tutorial.akash_thymeleaf_spring_boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AkashThymeleafSpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AkashThymeleafSpringBootApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {

		 Student student1 = new Student("Sergio", "Ramos", "ramos@gmail.com");
		 studentRepository.save(student1);
		 Student student2 = new Student("Lionel", "Messi", "messi@gmail.com");
		 studentRepository.save(student2);
		 Student student3 = new Student("Tony", "Stark", "iron_man@gmail.com");
		 studentRepository.save(student3);
	}
}
