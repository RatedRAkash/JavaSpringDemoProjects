package com.tutorial.akash_spring_cloud_stream;

import com.tutorial.akash_spring_cloud_stream.converter.TextPlainMessageConverter;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tutorial.akash_spring_cloud_stream.model.LogMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.converter.MessageConverter;


@SpringBootApplication
@EnableBinding(Processor.class)
public class AkashSpringCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkashSpringCloudStreamApplication.class, args);
	}

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public LogMessage enrichLogMessage(LogMessage log) {
		return new LogMessage(String.format("[1]: %s", log.getMessage()));
//		return "Akash"+log;
	}

}
