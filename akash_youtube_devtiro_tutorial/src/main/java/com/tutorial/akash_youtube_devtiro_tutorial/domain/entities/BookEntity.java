package com.tutorial.akash_youtube_devtiro_tutorial.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String isbn;

    private String title;

    // "CascadeType" bolte.. jokon amra kono "BookEntity" object dhore... sheitar vitor er "AuthorEntity" Change korbo...
    // shei "AuthorEntity" Object auto DATABASE ee Save/Update hobe
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;
}
