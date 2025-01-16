//package com.example.serviceTest;
//
//import com.example.dto.DtoToEmployee;
//import com.example.entity.Address;
//import com.example.entity.Employee;
//import com.example.repo.EmployeeRepo;
//import com.example.sevice.EmployeeServiceImpl;
//import com.example.utils.EmailUtils;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.List;
//
//public class EmployeeServiceImplTest {
//    @Mock
//    private EmployeeRepo employeeRepo;
//    @Mock
//    private EmailUtils emailUtils;
//    @InjectMocks
//    private EmployeeServiceImpl employeeServiceImpl;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this); // Initialize mocks
//    }
//
//    @Test
//    public void addEmployee_Success() {
//        DtoToEmployee dtoToEmployee = new DtoToEmployee();
//        dtoToEmployee.setFirstName("Saurabh");
//        dtoToEmployee.setLastName("Nimje");
//        dtoToEmployee.setEmail("saurabhnimje02@gmail.com");
//        dtoToEmployee.setPhno(9876587654);
//        dtoToEmployee.setAge(26);
//        dtoToEmployee.setGender("M");
//        dtoToEmployee.setDepartment("Developer");
//        dtoToEmployee.setNotes("Welcome TO SpringBoot, JUnit, Mockito");
//        dtoToEmployee.setSalary(45000.00);
//        dtoToEmployee.setProfilePic("saurabh");
////        private String addressType;
////        private String houseNo;
////        private String streetName;
////        private String city;
////        private String state;
////        private String pinCode;
////
////        Address address1 = new Address();
////        address1.setAddressType("Home");
////        address1.setHouseNo("123");
////        address1.setStreetName("Main Street");
////        address1.setCity("New York");
////        address1.setState("NY");
////        address1.setPinCode("10001");
////
////        dtoToEmployee.setDtoToAddresses(List.of(address1));
//
//        String str;
//        if (dtoToEmployee == null) {
//            str = "Enter All The Fields";
//        }
//        try {
//            Employee employee = convertToEntity(dtoToEmployee);
//            employeeRepo.save(employee);
//            String msg = emailUtils.sendEmail(employee.getEmail(), "Regarding SpringBoot Mail", "Welcome To SpringBoot Mail : " + employee.getFirstName());
////            log.info(" INFO Log : Employee Added Successfully");
//            str = "Employee : Employee Added Successfully " + " : " + " Mail Msg : " + msg;
//        } catch (Exception exception) {
////            log.error("Error Log : Employee Not Saved");
//            str = "Exception : " + exception.getMessage();
//        }
//        return str;
//    }
//}
