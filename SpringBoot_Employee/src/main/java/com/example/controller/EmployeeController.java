package com.example.controller;

import com.example.dto.DtoToEmployee;
import com.example.dto.EmployeeToDto;
import com.example.sevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmp")
    public String addEmployee( @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("gender") String gender,
                               @RequestParam("department") String department,
                               @RequestParam("notes") String notes,
                               @RequestParam("salary") Double salary,
                               @RequestParam("profilePic") MultipartFile profilePic
    ) throws IOException {
        byte[] profilePicBytes = profilePic.getBytes();

        // Create Employee DTO
        DtoToEmployee dtoToEmployee = new DtoToEmployee();
        dtoToEmployee.setFirstName(firstName);
        dtoToEmployee.setLastName(lastName);
        dtoToEmployee.setGender(gender);
        dtoToEmployee.setDepartment(department);
        dtoToEmployee.setNotes(notes);
        dtoToEmployee.setSalary(salary);
        dtoToEmployee.setProfilePic(profilePicBytes);

        // Call the service to save the employee
        return employeeService.addEmployee(dtoToEmployee);
    }

    @GetMapping("/getEmp/{id}")
    public Optional<EmployeeToDto> getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeToDto> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PutMapping("/updateEmp/{id}")
    public String updateEmployeeById(@PathVariable Integer id, @RequestBody DtoToEmployee employeeDto) {
        return employeeService.updateEmployeeById(id, employeeDto);
    }

    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmployeeById(@PathVariable Integer id) {
        return employeeService.deleteEmployeeById(id);
    }
}
