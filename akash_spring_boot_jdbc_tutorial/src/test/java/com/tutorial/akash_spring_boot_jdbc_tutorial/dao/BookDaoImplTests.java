package com.tutorial.akash_spring_boot_jdbc_tutorial.dao;

import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Author;
import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Book;
import com.tutorial.akash_spring_boot_jdbc_tutorial.repository_dao.author_dao.AuthorDaoImpl;
import com.tutorial.akash_spring_boot_jdbc_tutorial.repository_dao.book_dao.BookDaoImpl;
import com.tutorial.akash_spring_boot_jdbc_tutorial.row_mapper.AuthorRowMapper;
import com.tutorial.akash_spring_boot_jdbc_tutorial.row_mapper.BookRowMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl bookDaoImplUnderTest;


    @Test
    public void testCreateBookGeneratesCorrectSql() {
        Book book = Book.builder()
                .isbn("6392-102-103")
                .title("The Greatest Defender of All Time")
                .authorId(1L)
                .build();

        bookDaoImplUnderTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),

                eq("6392-102-103"),
                eq("The Greatest Defender of All Time"),
                eq(1L)
        );
    }

    @Test
    public void testThatFindOneBookByAndGeneratesCorrectSql() {
        bookDaoImplUnderTest.findOneById("6392-102-103");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookRowMapper>any(),
                eq("6392-102-103")
        );
    }
}
