package com.tutorial.akash_retrofit_client_spring_boot.controller;

import com.tutorial.akash_retrofit_client_spring_boot.restClient.RMARestClient;
import com.tutorial.akash_retrofit_client_spring_boot.restClient.api.AuthorApiService;
import com.tutorial.akash_retrofit_client_spring_boot.restClient.dto.AuthorResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @GetMapping("/")
    String home(){
        return "home";
    }


    @GetMapping(path = "/call-api")
    public List<AuthorResponseDto> call_api() throws Exception {
        return new RMARestClient<AuthorApiService, List<AuthorResponseDto>>()
                .setBaseUrl("http://localhost:8080/")
                .methodName("getAllAuthors()")
                .callApi(AuthorApiService.class, s -> s.getAllAuthors());
    }
}
