package com.tutorial.akash_youtube_devtiro_tutorial.domain.entities.one_to_one;

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
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String studentName;
    private Integer roll;

    //mappedBy ---> Student Table er sathe INERNALLY Laptop Table Connect korar jonno | BIDIRECTION Mapping er jonno use kori
    @OneToOne(mappedBy = "studentX", cascade = CascadeType.ALL) // mappedBy er jonno "Student Table" ee kono "FOREIGN_KEY" create hobe Nah...
    private Laptop laptop;
}
