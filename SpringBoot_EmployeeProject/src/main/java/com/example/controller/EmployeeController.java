package com.example.controller;

import com.example.dto.DtoToEmployee;
import com.example.dto.EmployeeToDto;
import com.example.exception.CustomException;
import com.example.sevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/addEmp")
    public String addEmployee(@Valid @RequestBody DtoToEmployee dtoToEmployee) {
        return employeeService.addEmployee(dtoToEmployee);
    }

    @GetMapping("/getEmp/{id}")
    public Optional<EmployeeToDto> getEmployeeById(@PathVariable Integer id) {
        if (employeeService.getEmployeeById(id).isPresent()) {
            return employeeService.getEmployeeById(id);
        } else throw new CustomException("No data found with ID : " + id);
    }

    @GetMapping
    public List<EmployeeToDto> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PutMapping("/updateEmp/{id}")
    public String updateEmployeeById(@PathVariable Integer id, @RequestBody DtoToEmployee employeeDto) {
        return employeeService.updateEmployeeById(id, employeeDto);
    }

    @PatchMapping("/patchEmp/{id}")
    public String patchEmployeeById(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        return employeeService.patchEmployeeById(id, updates);
    }

    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmployeeById(@PathVariable Integer id) {
        return employeeService.deleteEmployeeById(id);
    }

    @DeleteMapping("/deleteEmpAdd/{id}/{addressType}")
    public String deleteEmployeeAddressByAddressType(@PathVariable Integer id, @PathVariable String addressType) {
        return employeeService.deleteEmployeeAddressByAddressType(id, addressType);
    }
}
