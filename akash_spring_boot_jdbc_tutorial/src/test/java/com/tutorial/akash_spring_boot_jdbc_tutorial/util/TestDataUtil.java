package com.tutorial.akash_spring_boot_jdbc_tutorial.util;

import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Author;
import com.tutorial.akash_spring_boot_jdbc_tutorial.domain.Book;

public final class TestDataUtil {
    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Sergio Ramos")
                .age(34)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("6392-102-103")
                .title("The Greatest Defender of All Time")
                .authorId(1L)
                .build();
    }
}
