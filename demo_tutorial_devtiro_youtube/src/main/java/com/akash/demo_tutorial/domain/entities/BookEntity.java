package com.akash.demo_tutorial.domain.entities;

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
    private String isbn;

    private String title;

    // Cascade bolte.. jokon amra kono "BookEntity" object dhore... sheitar vitor er "AuthorEntity" Change korbo...
    // shei "AuthorEntity" Object auto DATABASE ee Save/Update hobe
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;
}
