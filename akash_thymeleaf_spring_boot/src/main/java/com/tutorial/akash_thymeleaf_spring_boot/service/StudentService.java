package com.tutorial.akash_thymeleaf_spring_boot.service;

import com.tutorial.akash_thymeleaf_spring_boot.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student registerStudent(Student student);

    public Student getStudentById(Long id);

    public Student updateStudent(Student student);

    public void deleteStudentById(Long id);
}
