package com.tutorial.akash_spring_boot_jdbc_tutorial.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private String isbn;

    private String title;

    private Long authorId;  // Jdbc er khetre Book class direct Database ee Reflect hobe, so amra eikane "Author" object use korte parbo Nah,
                            // amader eikane author table er Primary Key ke refer korte hobe eijonno amra "Long" diye authorId ke refer korbo
}