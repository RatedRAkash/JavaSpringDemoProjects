package com.tutorial.akash_rabbitmq_spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


@SpringBootApplication
public class AkashLatestSpringCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkashLatestSpringCloudStreamApplication.class, args);
	}


	//Producer
	@Bean
	public Supplier<String> myProducer() {
		return () -> "sergio ramos";
	}


	//Processor
	@Bean
	public Function<String, String> toUpperCase() {
		return (str) -> {
			str = str.toUpperCase();
			return str;
		};
	}

	
	//Consumer
	@Bean
	public Consumer<String> myConsumer() {
		return (str) -> {
			System.out.println(str);
		};
	}
}
