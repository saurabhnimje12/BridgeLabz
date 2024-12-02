package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stuId;
    private String stuName;
    private Integer stuAge;
    private String stuAddress;
    private String stuPhno;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> courses;
}
