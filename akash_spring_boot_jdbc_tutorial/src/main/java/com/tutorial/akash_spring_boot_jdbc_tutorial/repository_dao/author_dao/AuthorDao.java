package com.tutorial.akash_spring_boot_jdbc_tutorial.repository_dao.author_dao;


import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOneById(Long id);

    List<Author> findAll();

    void update(Long id, Author author);

    void delete(Long id);
}
