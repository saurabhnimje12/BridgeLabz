package com.example.sevice;

import com.example.dto.DtoToEmployee;
import com.example.dto.EmployeeToDto;
import com.example.entity.Employee;
import com.example.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public String addEmployee(DtoToEmployee dtoToEmployee) {
        String str;
        if (dtoToEmployee == null) {
            str = "Enter All The Fields";
        } try {
            Employee employee = convertToEntity(dtoToEmployee);
            employeeRepo.save(employee);
            log.info(" INFO Log : Employee Added Successfully");
            str = "Employee : Employee Added Successfully";
        } catch (Exception exception) {
            log.error("Error Log : Employee Not Saved");
            str = "Exception : " + exception.getMessage();
        }
        return str;
    }

    @Override
    public Optional<EmployeeToDto> getEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            return employee.map(this::convertToDTO); // Convert to DTO if found
        } else {
            log.error("Error Log : Employee Is Not Present with ID {}", id);
            return Optional.empty();
        }
    }

    @Override
    public List<EmployeeToDto> getAllEmployee() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(this::convertToDTO) // Convert each entity to DTO
                .collect(Collectors.toList());
    }

    @Override
    public String updateEmployeeById(Integer id, DtoToEmployee dtoToEmployee) {
        String str;
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            Employee emp = employee.get();
            emp.setFirstName(dtoToEmployee.getFirstName());
            emp.setLastName(dtoToEmployee.getLastName());
            emp.setGender(dtoToEmployee.getGender());
            emp.setDepartment(dtoToEmployee.getDepartment());
            emp.setNotes(dtoToEmployee.getNotes());
            emp.setSalary(dtoToEmployee.getSalary());
            emp.setProfilePic(dtoToEmployee.getProfilePic());
            employeeRepo.save(emp);
            log.info("INFO Log : Employee Updated Successfully with ID {}", id);
            str = "Employee updated successfully";
        } else {
            log.error("Error Log : Employee Is Not Found with ID {}", id);
            str = "Employee not found with ID: " + id;
        }
        return str;
    }

    @Override
    public String deleteEmployeeById(Integer id) {
        String str;
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            employeeRepo.deleteById(id);
            log.info("INFO Log : Employee Deleted Successfully with ID {}", id);
            str = "Employee deleted successfully.";
        } else {
            log.error("Error Log : Employee is Not Found with ID {}", id);
            str = "Employee not found with ID: " + id;
        }
        return str;
    }

    private Employee convertToEntity(DtoToEmployee dtoToEmployee) {
        Employee employee = new Employee();
        employee.setFirstName(dtoToEmployee.getFirstName());
        employee.setLastName(dtoToEmployee.getLastName());
        employee.setGender(dtoToEmployee.getGender());
        employee.setDepartment(dtoToEmployee.getDepartment());
        employee.setDateOfJoin(LocalDate.now());
        employee.setNotes(dtoToEmployee.getNotes());
        employee.setSalary(dtoToEmployee.getSalary());
        employee.setProfilePic(dtoToEmployee.getProfilePic());
        return employee;
    }

    private EmployeeToDto convertToDTO(Employee employee) {
        EmployeeToDto dto = new EmployeeToDto();
        dto.setEmpId(employee.getEmpId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setGender(employee.getGender());
        dto.setDepartment(employee.getDepartment());
        dto.setDateOfJoin(employee.getDateOfJoin());
        dto.setNotes(employee.getNotes());
        dto.setSalary(employee.getSalary());
        dto.setProfilePic(employee.getProfilePic());
        return dto;
    }

}
