package com.tutorial.akash_youtube_devtiro_tutorial.domain.entities.one_to_many;

import com.tutorial.akash_youtube_devtiro_tutorial.domain.entities.one_to_one.Student;
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
@Table(name="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    private String cityName;

    // CITY table ee giye Country er FOREIGN_KEY SAVE hobe
    @ManyToOne // Bi-directional Mapping er jonno
    @JoinColumn(name = "fk_country_id") // table ee FOREIGN_KEY er name hobe "fk_country_id"
    private Country countryX;
}