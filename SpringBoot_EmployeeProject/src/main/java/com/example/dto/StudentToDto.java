package com.example.dto;

import com.example.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentToDto {
    private Integer stuId;
    private String stuName;
    private Integer stuAge;
    private String stuAddress;
    private String stuPhno;
    private Set<Course> courses;
}
