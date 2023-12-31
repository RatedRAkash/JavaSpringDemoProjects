package com.tutorial.akash_youtube_devtiro_tutorial.controller;

import com.tutorial.akash_youtube_devtiro_tutorial.domain.dto.AuthorDto;
import com.tutorial.akash_youtube_devtiro_tutorial.domain.entity.AuthorEntity;
import com.tutorial.akash_youtube_devtiro_tutorial.mapper.CustomObjectMapper;
import com.tutorial.akash_youtube_devtiro_tutorial.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    private AuthorService authorService;
    private CustomObjectMapper<AuthorEntity, AuthorDto> authorMapper;

    public AuthorController(AuthorService authorService, CustomObjectMapper<AuthorEntity, AuthorDto> authorMapper){
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    //TODO: Controller Only "AuthorDto" Response hisave Dibe & Request hisave Nibe...
    // Controller Should have No Idea about AuthorEntity... ei karon DTO(Data Transfer Object) use kora huise AuthorEntity theke AuthorDto te nite
    // Persistence Layer(Repository) & Service Layer should access AuthorEntity

    @PostMapping(path = "/authors")
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        AuthorEntity authorEntity = authorMapper.mapFrom(authorDto);
        AuthorEntity savedAuthorEntity = authorService.save(authorEntity);


//        ResponseEntity ---> Response ee Custom STATUS CODE pathanor jonno amra eita Use kori...
//        eikane jemon CREATED er por 201 HTTP CODE Return korbe.. naile Normally use korle 200 Return kore
        return new ResponseEntity<>(authorMapper.mapTo(savedAuthorEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/authors")
    public List<AuthorDto> listAuthors(){
        List<AuthorEntity> authors = authorService.findAll();

        return authors.stream()
                .map(authorMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/authors/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable("id") Long id){
        Optional<AuthorEntity> foundAuthor = authorService.findOne(id);

        return foundAuthor.map(authorEntity -> {
            AuthorDto authorDto = authorMapper.mapTo(authorEntity);
            return new ResponseEntity<>(authorDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
