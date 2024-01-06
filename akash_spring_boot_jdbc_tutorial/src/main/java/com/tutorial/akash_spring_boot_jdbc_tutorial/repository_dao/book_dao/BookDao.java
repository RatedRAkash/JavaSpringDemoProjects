package com.tutorial.akash_spring_boot_jdbc_tutorial.repository_dao.book_dao;

import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Author;
import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Book;

import java.util.Optional;

public interface BookDao {

    void create(Book book);

    Optional<Book> findOneById(String isbn);
}
