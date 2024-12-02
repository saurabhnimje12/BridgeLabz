package com.example.sevice;

import com.example.dto.DtoToStudent;
import com.example.entity.Course;
import com.example.entity.Student;
import com.example.repo.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@Slf4j
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public String addStudent(DtoToStudent dtoToStudent) {
       String str;
        try{
            Student student = convertToStudentEntity(dtoToStudent);
            studentRepo.save(student);
//            log.info("INFO log : Student Added Successfully");
            str = "Student : Student Added Successfully";
        } catch (Exception exception){
//            log.error("ERROR log : Student NOT Added");
            str = "Exception : "+exception.getMessage();
        }
        return str;
    }


    private Student convertToStudentEntity(DtoToStudent dtoToStudent) {
        Student student = new Student();
        student.setStuName(dtoToStudent.getStuName());
        student.setStuAge(dtoToStudent.getStuAge());
        student.setStuAddress(dtoToStudent.getStuAddress());
        student.setStuPhno(dtoToStudent.getStuPhno());

        List<Course> collect = dtoToStudent.getCourses().stream().map(dtoToCourse -> {
            Course course = new Course();
            course.setCourName(dtoToCourse.getCourName());
            course.setCourDuration(dtoToCourse.getCourDuration());
            course.setCourRating(dtoToCourse.getCourRating());
            course.setStudents(dtoToCourse.getStudents());
            course.setStudents(dtoToCourse.getStudents());
            return course;
        }).collect(Collectors.toList());
        student.setCourses(collect);
        return student;
    }





}
