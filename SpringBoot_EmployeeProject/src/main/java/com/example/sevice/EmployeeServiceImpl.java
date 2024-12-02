package com.example.sevice;

import com.example.dto.AddressToDto;
import com.example.dto.DtoToEmployee;
import com.example.dto.EmployeeToDto;
import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.exception.CustomException;
import com.example.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
//@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private static final Set<String> ALLOWED_FIELDS = Set.of("firstName", "lastName", "email", "salary");
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public String addEmployee(DtoToEmployee dtoToEmployee) {
        String str;
        if (dtoToEmployee == null) {
            str = "Enter All The Fields";
        }
        try {
            Employee employee = convertToEntity(dtoToEmployee);
            employeeRepo.save(employee);
//            log.info(" INFO Log : Employee Added Successfully");
            str = "Employee : Employee Added Successfully";
        } catch (Exception exception) {
//            log.error("Error Log : Employee Not Saved");
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
//            log.error("Error Log : Employee Is Not Present with ID {}", id);
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
            emp.setEmail(dtoToEmployee.getEmail());
            emp.setPhno(dtoToEmployee.getPhno());
            emp.setAge(dtoToEmployee.getAge());
            emp.setGender(dtoToEmployee.getGender());
            emp.setDepartment(dtoToEmployee.getDepartment());
            emp.setNotes(dtoToEmployee.getNotes());
            emp.setSalary(dtoToEmployee.getSalary());
            emp.setProfilePic(dtoToEmployee.getProfilePic());

            // Convert and set addresses
            List<Address> addresses = dtoToEmployee.getDtoToAddresses().stream().map(dtoAddress -> {
                Address address = new Address();
                address.setAddressType(dtoAddress.getAddressType());
                address.setHouseNo(dtoAddress.getHouseNo());
                address.setStreetName(dtoAddress.getStreetName());
                address.setCity(dtoAddress.getCity());
                address.setState(dtoAddress.getState());
                address.setPinCode(dtoAddress.getPinCode());
                address.setEmployee(emp); // Establish the relationship
                return address;
            }).collect(Collectors.toList());
            emp.setAddresses(addresses);

            employeeRepo.save(emp);
//            log.info("INFO Log : Employee Updated Successfully with ID {}", id);
            str = "Employee updated successfully";
        } else {
//            log.error("Error Log : Employee Is Not Found with ID {}", id);
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
//            log.info("INFO Log : Employee Deleted Successfully with ID {}", id);
            str = "Employee deleted successfully.";
        } else {
//            log.error("Error Log : Employee is Not Found with ID {}", id);
            str = "Employee not found with ID: " + id;
        }
        return str;
    }

    @Override
    public String deleteEmployeeAddressByAddressType(Integer id, String addressType) {
        String msg;
        Optional<Employee> employeeById = employeeRepo.findById(id);
//        Optional<EmployeeToDto> employeeById = getEmployeeById(id);
        if (employeeById.isPresent()) {
            Employee employee = employeeById.get();
            Optional<Address> addressToDelete = employee.getAddresses()
                    .stream()
                    .filter(address -> address.getAddressType().equalsIgnoreCase(addressType))
                    .findFirst();

            if (addressToDelete.isPresent()) {
                employee.getAddresses().remove(addressToDelete.get());
//                Employee employee = convertToEntity(employeeToDto);
                employeeRepo.save(employee);
//                log.info("INFO Log: Address Deleted Successfully with Address-Type {}", addressType);
                msg = "Address deleted successfully.";
            } else {
//                log.error("ERROR Log: Address Not Found with Address-Type {}", addressType);
                msg = "Address not found with Address-Type: " + addressType;
            }
        } else {
//            log.error("ERROR Log: Employee Not Found with ID {}", id);
            msg = "Employee not found with ID: " + id;
        }
        return msg;
    }

    @Override
    public String patchEmployeeById(Integer id, Map<String, Object> updates) {
        String str;
        Optional<Employee> byId = employeeRepo.findById(id);
        if (byId.isPresent()) {
            Employee employee = byId.get();
            updates.forEach((field, value) -> {
//                if (ALLOWED_FIELDS.contains(field)) {

                    Field declaredField = ReflectionUtils.findField(Employee.class, field);
                    if (declaredField != null) {
                        declaredField.setAccessible(true);
                        ReflectionUtils.setField(declaredField, employee, value);}

//                } else {
//                    log.error("ERROR log : Field cannot be allowed to updated {}", field);
//                    throw new CustomException("Field cannot be allowed to updated : " + field);
//                }
            });
            employeeRepo.save(employee);
            str = "Employee updated successfully.";
//            log.info("INFO log : Filed Updated successfully ");
        } else {
            str = "Employee not found with ID: " + id;
//            log.error("Error log : Employee not found with ID : {}", id);
        }
        return str;
    }

    private Employee convertToEntity(DtoToEmployee dtoToEmployee) {
        Employee employee = new Employee();
        employee.setFirstName(dtoToEmployee.getFirstName());
        employee.setLastName(dtoToEmployee.getLastName());
        employee.setEmail(dtoToEmployee.getEmail());
        employee.setPhno(dtoToEmployee.getPhno());
        employee.setAge(dtoToEmployee.getAge());
        employee.setGender(dtoToEmployee.getGender());
        employee.setDepartment(dtoToEmployee.getDepartment());
        employee.setDateOfJoin(LocalDate.now());
        employee.setNotes(dtoToEmployee.getNotes());
        employee.setSalary(dtoToEmployee.getSalary());
        employee.setProfilePic(dtoToEmployee.getProfilePic());

        // Convert and set addresses
        List<Address> addresses = dtoToEmployee.getDtoToAddresses().stream().map(dtoAddress -> {
            Address address = new Address();
            address.setAddressType(dtoAddress.getAddressType());
            address.setHouseNo(dtoAddress.getHouseNo());
            address.setStreetName(dtoAddress.getStreetName());
            address.setCity(dtoAddress.getCity());
            address.setState(dtoAddress.getState());
            address.setPinCode(dtoAddress.getPinCode());
            address.setEmployee(employee); // Establish the relationship
            return address;
        }).collect(Collectors.toList());
        employee.setAddresses(addresses);
        return employee;
    }

    private EmployeeToDto convertToDTO(Employee employee) {
        EmployeeToDto dto = new EmployeeToDto();
        dto.setEmpId(employee.getEmpId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        dto.setPhno(employee.getPhno());
        dto.setAge(employee.getAge());
        dto.setGender(employee.getGender());
        dto.setDepartment(employee.getDepartment());
        dto.setDateOfJoin(employee.getDateOfJoin());
        dto.setNotes(employee.getNotes());
        dto.setSalary(employee.getSalary());
        dto.setProfilePic(employee.getProfilePic());

        // Convert addresses to DTOs
        List<AddressToDto> addressDtos = employee.getAddresses().stream().map(address -> {
            AddressToDto addressToDto = new AddressToDto();
            addressToDto.setAddressType(address.getAddressType());
            addressToDto.setHouseNo(address.getHouseNo());
            addressToDto.setStreetName(address.getStreetName());
            addressToDto.setCity(address.getCity());
            addressToDto.setState(address.getState());
            addressToDto.setPinCode(address.getPinCode());
            return addressToDto;
        }).collect(Collectors.toList());
        dto.setAddress(addressDtos);
        return dto;
    }

}
