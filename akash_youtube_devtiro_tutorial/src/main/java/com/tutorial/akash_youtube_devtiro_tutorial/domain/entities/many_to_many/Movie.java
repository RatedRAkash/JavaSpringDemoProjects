package com.tutorial.akash_youtube_devtiro_tutorial.domain.entities.many_to_many;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String movieName;

    // "Movie" SAVE korle "Category" automatic SAVE hoye jabe CASCADE er jonno
    @ManyToMany(mappedBy = "movieListX", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Category> categoryList = new ArrayList<>();

//    LAZY = fetch when needed
//    EAGER = fetch immediately

}