package com.example.service;

import com.example.entity.Student;

import java.util.List;

public interface StudentService {
    public String addStudent(Student student);

    public String updateStudent(Long id, Student student);

    public String deleteStudent(Long id);

    public List<Student> getAllStudent();

    public Student getStudentById(Long id);
}
