package com.tutorial.akash_thymeleaf_spring_boot.service;

import com.tutorial.akash_thymeleaf_spring_boot.entity.Student;
import com.tutorial.akash_thymeleaf_spring_boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


    @Override
    public Student registerStudent(Student student){
        return studentRepository.save(student);
    }


    @Override
    public Student getStudentById(Long id){
        Student student = studentRepository.findById(id).get();
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}
