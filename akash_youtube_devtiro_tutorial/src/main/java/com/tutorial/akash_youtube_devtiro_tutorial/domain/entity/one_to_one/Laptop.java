package com.tutorial.akash_youtube_devtiro_tutorial.domain.entity.one_to_one;

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
@Table(name="laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laptopId;

    private String modelNumber;
    private String brandName;

    @OneToOne // Laptop table ee FOREIGN_KEY create hobe
    @JoinColumn(name = "fk_student_id") // table ee FOREIGN_KEY er name hobe "fk_student_id"
    private Student studentX;
}
