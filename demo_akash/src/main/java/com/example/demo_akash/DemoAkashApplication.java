package com.example.demo_akash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //*** OpenFeign use korte Must ei Annotation dewa lagbe ***
public class DemoAkashApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAkashApplication.class, args);
	}
}
