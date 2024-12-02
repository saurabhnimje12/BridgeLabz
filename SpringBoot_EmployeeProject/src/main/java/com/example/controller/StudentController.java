package com.example.controller;

import com.example.dto.DtoToStudent;
import com.example.sevice.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStu")
    public String addStudent(@Valid @RequestBody DtoToStudent dtoToStudent){
        return studentService.addStudent(dtoToStudent);
    }



}
