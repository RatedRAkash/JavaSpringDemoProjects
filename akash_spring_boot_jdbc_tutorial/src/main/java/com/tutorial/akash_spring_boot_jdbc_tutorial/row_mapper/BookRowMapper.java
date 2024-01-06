package com.tutorial.akash_spring_boot_jdbc_tutorial.row_mapper;

import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Author;
import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    //TODO: since we are using Spring JDBC, we have to Manually Map or SQL Objects to our JAVA Objects... that's where we use RowMapper class
    // resultSet = SQL Object, ei resultSet thekei amra attributes Extract kore sheigula Book Class ee dukhaye NEW Book Object create korbo

    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Book.builder()
                .isbn(resultSet.getString("isbn"))
                .title(resultSet.getString("title"))
                .authorId(resultSet.getLong("author_id"))
                .build();
    }
}