//package com.akash.demo_tutorial.dao.impl;
//
//import com.akash.demo_tutorial.domain.entities.AuthorEntity;
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
//public class AuthorDaoImplTests {
//
//    @Mock
//    private JdbcTemplate jdbcTemplate;
//
//    @InjectMocks
//    private AuthorDaoImpl underTest;  // AuthorDaoImpl er moddhe jei Constructor ase... sheikane upor er "@Mock" diye JdbcTemplate amra Auto Inject korte parbo
//
//    @Test
//    public void testThatCreateAuthorGeneratesCorrectSql() {
//        AuthorEntity author = AuthorEntity.builder()
//                .id(1L)
//                .name("Sergio Ramos")
//                .age(80)
//                .build();
//
//        underTest.create(author);
//
//        verify(jdbcTemplate).update(
//                eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
//                eq(1L), eq("Sergio Ramos"), eq(80)
//        );
//    }
//}
