package com.akash.demo_tutorial.services.impl;


import com.akash.demo_tutorial.domain.entities.AuthorEntity;
import com.akash.demo_tutorial.repositories.AuthorRepository;
import com.akash.demo_tutorial.services.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }
}
