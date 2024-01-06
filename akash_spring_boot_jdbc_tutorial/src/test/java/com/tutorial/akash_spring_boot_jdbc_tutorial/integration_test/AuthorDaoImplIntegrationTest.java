package com.tutorial.akash_spring_boot_jdbc_tutorial.integration_test;


import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Author;
import com.tutorial.akash_spring_boot_jdbc_tutorial.repository_dao.author_dao.AuthorDaoImpl;
import com.tutorial.akash_spring_boot_jdbc_tutorial.util.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorDaoImplIntegrationTest {

    private AuthorDaoImpl authorDaoImplUnderTest;

    @Autowired
    public AuthorDaoImplIntegrationTest(AuthorDaoImpl authorDaoImplUnderTest) {
        this.authorDaoImplUnderTest = authorDaoImplUnderTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthor();
        authorDaoImplUnderTest.create(author);
        Optional<Author> result = authorDaoImplUnderTest.findOneById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }
}
