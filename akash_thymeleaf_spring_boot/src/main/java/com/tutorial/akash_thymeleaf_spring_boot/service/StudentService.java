package com.tutorial.akash_thymeleaf_spring_boot.service;

import com.tutorial.akash_thymeleaf_spring_boot.entity.Student;
import com.tutorial.akash_thymeleaf_spring_boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.engine.ISSEThrottledTemplateWriterControl;
import org.thymeleaf.model.IStandaloneElementTag;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student registerStudent(Student student){
        return studentRepository.save(student);
    }
}
