package com.example.dto;

import com.example.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoToCourse {
    private String courName;
    private String courDuration;
    private double courRating;
    private List<Student> students;
}
