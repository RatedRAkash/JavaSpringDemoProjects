package com.example.demo_akash.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//@Configuration
public class StudentConfig {

//    prothom bar Application Run korle jeno kono Data Load hui eitar jonno ei StudentConfig Add kora
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student akash = new Student(
                    "Akash",
                    "akash@tallykhata.com",
                    LocalDate.of(1997, Month.NOVEMBER, 29),
                    "akash6392"
            );

            Student ramos = new Student(
                    "Ramos",
                    "sr4@gmail.com",
                    LocalDate.of(1986, Month.MARCH, 30),
                    "ramos_madrid"
            );

            studentRepository.saveAll(
                    List.of(akash, ramos)
            );

        };
    }

}
