package com.example.dto;

import com.example.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoToStudent {
    private String stuName;
    private Integer stuAge;
    private String stuAddress;
    private String stuPhno;
    private List<Course> courses;
}
