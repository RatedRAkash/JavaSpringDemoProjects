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
        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author); //as FOREIGN_KEY constraint so, agge Author Create kore Database ee INSERT korte hobe, naile bari khabe

        Book book = TestDataUtil.createTestBook();
        book.setAuthorId(author.getId());
        bookDaoImplUnderTest.create(book);
        Optional<Book> result = bookDaoImplUnderTest.findOneByIsbn(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }
}
