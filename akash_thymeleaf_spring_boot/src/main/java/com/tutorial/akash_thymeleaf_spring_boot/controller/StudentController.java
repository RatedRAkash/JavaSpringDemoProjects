package com.tutorial.akash_thymeleaf_spring_boot.controller;

import com.tutorial.akash_thymeleaf_spring_boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "all_students";
    }
}
