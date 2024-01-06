package com.tutorial.akash_spring_boot_jdbc_tutorial.repository_dao.author_dao;

import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Author;
import com.tutorial.akash_spring_boot_jdbc_tutorial.row_mapper.AuthorRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AuthorDaoImpl implements AuthorDao {
    private final JdbcTemplate jdbcTemplate; //DatabaseConfig file theke JdbcTemplate er @Bean eikane Autowired hobe

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update(
                "INSERT INTO authors (id, name, age) VALUES (?, ?, ?)",
                author.getId(), author.getName(), author.getAge()
        );
    }

    @Override
    public Optional<Author> findOneById(Long id) {
        List<Author> results = jdbcTemplate.query(
                                        "SELECT id, name, age FROM authors WHERE id = ? LIMIT 1",
                                        new AuthorRowMapper(),
                                        id
                                );

        return results.stream().findFirst();
    }
}
