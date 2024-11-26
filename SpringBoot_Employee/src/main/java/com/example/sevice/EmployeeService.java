package com.example.sevice;

import com.example.dto.DtoToEmployee;
import com.example.dto.EmployeeToDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    String addEmployee(DtoToEmployee dtoToEmployee);

    Optional<EmployeeToDto> getEmployeeById(Integer id);

    List<EmployeeToDto> getAllEmployee();

    String updateEmployeeById(Integer id, DtoToEmployee dtoToEmployee);

    String deleteEmployeeById(Integer id);
}
