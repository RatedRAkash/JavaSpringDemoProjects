package com.tutorial.akash_rabbitmq_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class AkashLatestSpringCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkashLatestSpringCloudStreamApplication.class, args);
	}

	@Bean
	public Function<String, String> toUpperCase(){
		return (str) -> {
			str = str.toUpperCase();
			System.out.println(str);
			return str;
		};
	}
}
