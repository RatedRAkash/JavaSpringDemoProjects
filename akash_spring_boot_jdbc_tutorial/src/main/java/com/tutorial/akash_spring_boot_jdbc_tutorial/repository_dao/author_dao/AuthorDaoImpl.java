package com.tutorial.akash_spring_boot_jdbc_tutorial.repository_dao.author_dao;

import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;

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
}
