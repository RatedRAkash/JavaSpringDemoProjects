package com.tutorial.akash_spring_boot_jdbc_tutorial.integration_test;

import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Author;
import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Book;
import com.tutorial.akash_spring_boot_jdbc_tutorial.repository_dao.author_dao.AuthorDao;
import com.tutorial.akash_spring_boot_jdbc_tutorial.repository_dao.book_dao.BookDaoImpl;
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
public class BookDaoImplIntegrationTest {

    private BookDaoImpl bookDaoImplUnderTest;
    private AuthorDao authorDao; //jehetu FOREIGN_KEY constraints ase, so amader agge Author Object Create korte hobe...

    @Autowired
    public BookDaoImplIntegrationTest(BookDaoImpl bookDaoImplUnderTest, AuthorDao authorDao) {
        this.bookDaoImplUnderTest = bookDaoImplUnderTest;
        this.authorDao = authorDao;
    }
    
    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author); //as FOREIGN_KEY constraint so, agge Author Create kore Database ee INSERT korte hobe, naile bari khabe

        Book book = TestDataUtil.createTestBookA();
        book.setAuthorId(author.getId());
        bookDaoImplUnderTest.create(book);
        Optional<Book> result = bookDaoImplUnderTest.findOneByIsbn(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);

        Book bookA = TestDataUtil.createTestBookA();
        bookA.setAuthorId(author.getId());
        bookDaoImplUnderTest.create(bookA);

        Book bookB = TestDataUtil.createTestBookB();
        bookB.setAuthorId(author.getId());
        bookDaoImplUnderTest.create(bookB);

        Book bookC = TestDataUtil.createTestBookC();
        bookC.setAuthorId(author.getId());
        bookDaoImplUnderTest.create(bookC);

        List<Book> result = bookDaoImplUnderTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactly(bookA, bookB, bookC);
    }

    @Test
    public void testThatBookCanBeUpdated() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);

        Book bookA = TestDataUtil.createTestBookA();
        bookA.setAuthorId(author.getId());
        bookDaoImplUnderTest.create(bookA);

        bookA.setTitle("UPDATED");
        bookDaoImplUnderTest.update(bookA.getIsbn(), bookA);

        Optional<Book> result = bookDaoImplUnderTest.findOneByIsbn(bookA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookA);
    }

    @Test
    public void testThatBookCanBeDeleted() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);

        Book bookA = TestDataUtil.createTestBookA();
        bookA.setAuthorId(author.getId());
        bookDaoImplUnderTest.create(bookA);

        bookDaoImplUnderTest.delete(bookA.getIsbn());

        Optional<Book> result = bookDaoImplUnderTest.findOneByIsbn(bookA.getIsbn());
        assertThat(result).isEmpty();
    }
}
