package com.tutorial.akash_spring_boot_jdbc_tutorial.row_mapper;

import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {

    //TODO: since we are using Spring JDBC, we have to Manually Map or SQL Objects to our JAVA Objects... that's where we use RowMapper class
    // resultSet = SQL Object, ei resultSet thekei amra attributes Extract kore sheigula Author Class ee dukhaye NEW Author Object create korbo

    @Override
    public Author mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Author.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .age(resultSet.getInt("age"))
                .build();
    }
}