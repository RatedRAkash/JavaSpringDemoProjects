package com.tutorial.akash_thymeleaf_spring_boot.repository;

import com.tutorial.akash_thymeleaf_spring_boot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository er Implemented Class "SimpleJpaRepository" already @Repository diye annotated
public interface StudentRepository extends JpaRepository<Student, Long> {

}
