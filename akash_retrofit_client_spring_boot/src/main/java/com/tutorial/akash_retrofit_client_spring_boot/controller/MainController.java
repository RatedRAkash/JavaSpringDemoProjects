package com.tutorial.akash_retrofit_client_spring_boot.controller;

import com.tutorial.akash_retrofit_client_spring_boot.FutureStudioTutorial.FutureStudioRestClient;
import com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism.RMARestClient;
import com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism.api.AuthorApiService;
import com.tutorial.akash_retrofit_client_spring_boot.RestClientAdvanceMechanism.dto.AuthorResponseDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @GetMapping("/")
    String home(){
        return "home";
    }

    @GetMapping(path = "/simple-call-api")
    public List<com.tutorial.akash_retrofit_client_spring_boot.FutureStudioTutorial.dto.AuthorResponseDto> simple_call_api() throws Exception {
        FutureStudioRestClient futureStudioRestClient = new FutureStudioRestClient("http://localhost:8080");
        return futureStudioRestClient.getResponseResult();
//        return ServiceGenerator.callApi(com.tutorial.akash_retrofit_client_spring_boot.FutureStudioTutorial.AuthorApiService.class, s->s.getAllAuthors());
//        return ServiceGenerator.createService(com.tutorial.akash_retrofit_client_spring_boot.FutureStudioTutorial.AuthorApiService.class).getAllAuthors().execute().body();
    }

    @GetMapping(path = "/call-api")
    public List<AuthorResponseDto> advance_call_api() throws Exception {
        return new RMARestClient<AuthorApiService, List<AuthorResponseDto>>()
                .setBaseUrl("http://localhost:8080")
                .methodName("getAllAuthors()")
                .callApi(AuthorApiService.class, s -> s.getAllAuthors());
    }
}
