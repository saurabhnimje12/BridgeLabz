package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/test")
    public  String test(){
        return "Spring-boot : Student Controller";
    }

    @PostMapping("/api/students")
    public ResponseEntity<String> addStudent(@RequestAttribute("role") String role, @RequestBody Student student) {
        if ("ADMIN".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(studentService.addStudent(student), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Token InValid to Access", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/api/students/{id}")
    public ResponseEntity<String> updateStudent(@RequestAttribute("role") String role, @PathVariable Long id, @RequestBody Student student) {
        if ("ADMIN".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(studentService.updateStudent(id, student), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("TToken InValid to Access", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/api/students/{id}")
    public ResponseEntity<String> deleteStudent(@RequestAttribute("role") String role, @PathVariable Long id) {
        if ("ADMIN".equalsIgnoreCase(role)) {
            return new ResponseEntity<String>(studentService.deleteStudent(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("TToken InValid to Access", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent() {
        return new ResponseEntity<List<Student>>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
    }
}
