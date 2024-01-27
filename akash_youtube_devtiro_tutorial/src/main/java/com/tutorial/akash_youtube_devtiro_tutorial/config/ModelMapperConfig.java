package com.tutorial.akash_youtube_devtiro_tutorial.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

//    ekta Entity theke Java Class er Dto te convert korar jonno ei ModelMapper er Instance amra Use korbo
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
