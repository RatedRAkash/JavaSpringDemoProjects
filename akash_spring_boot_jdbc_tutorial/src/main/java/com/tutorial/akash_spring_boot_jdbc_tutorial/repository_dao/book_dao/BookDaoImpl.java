package com.tutorial.akash_spring_boot_jdbc_tutorial.repository_dao.book_dao;

import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Book;
import com.tutorial.akash_spring_boot_jdbc_tutorial.row_mapper.BookRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
public class BookDaoImpl implements BookDao {
    private final JdbcTemplate jdbcTemplate; //DatabaseConfig file theke JdbcTemplate er @Bean eikane Autowired hobe

    public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Book book) {

        jdbcTemplate.update(
                "INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)",
                book.getIsbn(),book.getTitle(), book.getAuthorId()
        );
    }

    @Override
    public Optional<Book> findOneByIsbn(String isbn) {
        List<Book> results = jdbcTemplate.query(
                "SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1",
                new BookRowMapper(),
                isbn
        );

        return results.stream().findFirst();
    }
}
