package com.tutorial.akash_spring_cloud_stream;

//import com.tutorial.akash_spring_cloud_stream.converter.TextPlainMessageConverter;
import com.tutorial.akash_spring_cloud_stream.model.LogMessage;
import com.tutorial.akash_spring_cloud_stream.producer.MessageProducer;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.tutorial.akash_spring_cloud_stream.model.LogMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.converter.MessageConverter;


@SpringBootApplication
//@EnableBinding(Processor.class)
public class AkashSpringCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkashSpringCloudStreamApplication.class, args);

		// Get the MessageProducer bean
//		MessageProducer messageProducer = context.getBean(MessageProducer.class);
//
//		// Send messages
//		messageProducer.sendMessage("Hello from the Ramos!");
//
//		// Close the context Spring Boot Application oo Close hoye jabe tokon
//		context.close();
	}

//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
//	public LogMessage enrichLogMessage(LogMessage log) {
//		return new LogMessage(String.format("[1]: %s", log.getMessage()));
////		return "Akash"+log;
//	}

}
