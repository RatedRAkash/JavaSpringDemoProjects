package com.tutorial.akash_youtube_devtiro_tutorial.service;

import com.tutorial.akash_youtube_devtiro_tutorial.domain.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    AuthorEntity save(AuthorEntity author);

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findOne(Long id);
}
