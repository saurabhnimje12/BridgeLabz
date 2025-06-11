package com.example.serviceImpl;

import com.example.entity.Student;
import com.example.repo.StudentRepo;
import com.example.service.StudentService;
import com.example.utils.CustomiseException;
import com.example.utils.EmailUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepo stuRepo;
    private EmailUtils emailUtils;

    public StudentServiceImpl(StudentRepo stuRepo, EmailUtils emailUtils) {
        this.stuRepo = stuRepo;
        this.emailUtils = emailUtils;
    }

    @Override
    public String addStudent(Student student) {
        if (stuRepo.findByEmail(student.getEmail()).isPresent()) {
            return "Student Is Already Present with Email | Try with different Email";
        }
        stuRepo.save(student);
        emailUtils.sendEmail(student.getEmail(), "Welcome To Student Management Application", String.format("Hello, %s! Your registration was successful!!", student.getFirstName()));
        return "Student Added Successfully||";
    }

    @Override
    public String updateStudent(Long id, Student student) {
        Optional<Student> stuById = stuRepo.findById(id);
        if (stuById.isPresent()) {
            Student stu = stuById.get();
            stu.setFirstName(student.getFirstName());
            stu.setLastName(student.getLastName());
            stu.setEmail(student.getEmail());
            stu.setDepartment(student.getDepartment());
            stu.setMobile(student.getMobile());
            stu.setDob(student.getDob());
            stuRepo.save(stu);
            return "Student Updated Successfully||";
        }
        return "Student Is NOT Present with Id | Try with different Id";
    }

    @Override
    public String deleteStudent(Long id) {
        Optional<Student> stuById = stuRepo.findById(id);
        if (stuById.isPresent()) {
            stuRepo.deleteById(id);
            return "Student Deleted Successfully||";
        }
        return "Student Is NOT Present with Id | Try with different Id";
    }

    @Override
    public List<Student> getAllStudent() {
        return stuRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return stuRepo.findById(id).orElseThrow(() -> new CustomiseException("Student Is NOT Present with Id | Try with different Id"));

    }
}
