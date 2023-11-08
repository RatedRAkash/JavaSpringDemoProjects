//package com.akash.demo_tutorial.dao.impl;
//
//import com.akash.demo_tutorial.domain.entities.BookEntity;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//public class BookEntityDaoImplTests {
//
//    @Mock
//    private JdbcTemplate jdbcTemplate;
//
//    @InjectMocks
//    private BookDaoImpl underTest;  // BookDaoImpl er moddhe jei Constructor ase... sheikane upor er "@Mock" diye JdbcTemplate amra Auto Inject korte parbo
//
//    @Test
//    public void testThatCreateBookGeneratesCorrectSql() {
//
//        BookEntity book = BookEntity.builder()
//                .isbn("978-1-2345-6789-0")
//                .title("The Best Book in the World")
//                .authorId(1L)
//                .build();
//
//        underTest.create(book);
//
//        verify(jdbcTemplate).update(
//                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
//                eq("978-1-2345-6789-0"),
//                eq("The Best Book in the World"),
//                eq(1L)
//        );
//    }
//}
