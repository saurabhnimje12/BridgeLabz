package com.example.sevice;

import com.example.dto.DtoToStudent;

import javax.validation.Valid;

public interface StudentService {
    String addStudent(@Valid DtoToStudent dtoToStudent);
}
