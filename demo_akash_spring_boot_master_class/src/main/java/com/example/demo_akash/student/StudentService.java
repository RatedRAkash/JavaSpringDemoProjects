package com.example.demo_akash.student;

import com.example.demo_akash.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(Long id){
        return getStudents()
                .stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new NotFoundException("Student with id " + id + " Not Found"));
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }else{
            studentRepository.save(student);
        }
    }

    public void updateStudent(Student student) {
        System.out.println(student);
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student. getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }else{
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long student_id) {
        boolean exists = studentRepository.existsById(student_id);

        if(!exists){
            throw new IllegalStateException("Student with ID" + student_id + " does not exists");
        }
        studentRepository.deleteById(student_id);
    }
}
