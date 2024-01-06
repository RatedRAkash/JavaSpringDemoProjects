package com.tutorial.akash_spring_boot_jdbc_tutorial.dao;

import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Author;
import com.tutorial.akash_spring_boot_jdbc_tutorial.repository_dao.author_dao.AuthorDaoImpl;
import com.tutorial.akash_spring_boot_jdbc_tutorial.row_mapper.AuthorRowMapper;
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
public class AuhorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl authorDaoImplUnderTest;


    @Test
    public void testCreateAuthorGeneratesCorrectSql(){
        Author author = Author.builder()
                .id(1L)
                .name("Sergio Ramos")
                .age(34)
                .build();

        authorDaoImplUnderTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
                eq(1L), eq("Sergio Ramos"), eq(34)
        );
    }

    @Test
    public void testThatFindOneAuthorByAndGeneratesCorrectSql() {
        authorDaoImplUnderTest.findOneById(1L);

        verify(jdbcTemplate).query(
                eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
                ArgumentMatchers.<AuthorRowMapper>any(),
                eq(1L)
        );
    }
}
