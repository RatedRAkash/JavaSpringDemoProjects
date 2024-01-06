package com.tutorial.akash_spring_boot_jdbc_tutorial.integration_test;

import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Author;
import com.tutorial.akash_spring_boot_jdbc_tutorial.repository_dao.author_dao.AuthorDaoImpl;
import com.tutorial.akash_spring_boot_jdbc_tutorial.util.TestDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
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

    //TODO: Run Tests Individually or Else you will get Same Primary Key Error

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDaoImplUnderTest.create(author);
        Optional<Author> result = authorDaoImplUnderTest.findOneById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        Author authorA = TestDataUtil.createTestAuthorA();
        authorDaoImplUnderTest.create(authorA);
        Author authorB = TestDataUtil.createTestAuthorB();
        authorDaoImplUnderTest.create(authorB);
        Author authorC = TestDataUtil.createTestAuthorC();
        authorDaoImplUnderTest.create(authorC);

        List<Author> result = authorDaoImplUnderTest.findAll();
        assertThat(result)
                .hasSize(3).
                containsExactly(authorA, authorB, authorC);
    }

    @Test
    public void testThatAuthorCanBeUpdated() {
        Author authorA = TestDataUtil.createTestAuthorA();
        authorDaoImplUnderTest.create(authorA);
        authorA.setName("UPDATED");
        authorDaoImplUnderTest.update(authorA.getId(), authorA);
        Optional<Author> result = authorDaoImplUnderTest.findOneById(authorA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(authorA);
    }

    @Test
    public void testThatAuthorCanBeDeleted() {
        Author authorA = TestDataUtil.createTestAuthorA();
        authorDaoImplUnderTest.create(authorA);
        authorDaoImplUnderTest.delete(authorA.getId());
        Optional<Author> result = authorDaoImplUnderTest.findOneById(authorA.getId());
        assertThat(result).isEmpty();
    }
}
