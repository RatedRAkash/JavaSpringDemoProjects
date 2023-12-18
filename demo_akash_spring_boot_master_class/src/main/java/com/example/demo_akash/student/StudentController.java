package com.example.demo_akash.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Long student_id){
        return studentService.getStudent(student_id);
    }

    @PostMapping
    public void registerNewStudent(@Valid @RequestBody Student student){ // @Valid ---> use nah korle Student object er VALIDATION kaaj korbe Nah
        studentService.addNewStudent(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long student_id){
        studentService.deleteStudent(student_id);
    }

}
