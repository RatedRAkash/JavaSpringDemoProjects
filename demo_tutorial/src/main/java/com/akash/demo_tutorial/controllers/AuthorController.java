package com.akash.demo_tutorial.controllers;

import com.akash.demo_tutorial.domain.dto.AuthorDto;
import com.akash.demo_tutorial.domain.entities.AuthorEntity;
import com.akash.demo_tutorial.mappers.CustomObjectMapper;
import com.akash.demo_tutorial.services.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    private AuthorService authorService;
    private CustomObjectMapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, CustomObjectMapper<AuthorEntity, AuthorDto> authorMapper){
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping(path = "/authors")
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto){
        AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);
        return authorMapper.mapTo(savedAuthorEntity);
    }

}
