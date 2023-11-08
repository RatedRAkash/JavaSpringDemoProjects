package com.akash.demo_tutorial;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DemoTutorialApplication {


//	Persistance Layer(Repository)  ---> AuthorEntity ---> Service Layer(Services) ---> AuthorDto ---> Presentation Layer(Controllers) ---> will sent the AuthorDto as Json as Api Response

//	AuthorEntity ---> ModelMapper ---> AuthorDto

	private final DataSource dataSource;

	public DemoTutorialApplication(final DataSource dataSource){
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoTutorialApplication.class, args);
	}

//	implements CommandLineRunner ---> eita SpringBoot Application Start er por ONCE in Application er Lifetime ee Start korte eita use kori amra
//	@Override
//	public void run(String... args) throws Exception {
//		log.info("Datasource name: "+dataSource.toString());
//		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
//		restTemplate.execute("select 1");
//	}
}
