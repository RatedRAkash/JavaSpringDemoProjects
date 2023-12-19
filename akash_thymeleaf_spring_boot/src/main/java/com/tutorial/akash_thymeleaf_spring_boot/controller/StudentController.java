package com.tutorial.akash_thymeleaf_spring_boot.controller;

import com.tutorial.akash_thymeleaf_spring_boot.entity.Student;
import com.tutorial.akash_thymeleaf_spring_boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//     handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model){
        // ei "students_obj" kei Thymeleaf er Template ee Access korte parbo
        model.addAttribute("students_all_obj", studentService.getAllStudents());

        // HTML FILE er name Return korbo
        return "layout/all_students";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.registerStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/student/create")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student_obj", student);

        return "layout/create_student";
    }
}
