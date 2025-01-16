package com.example.aspect;

import com.example.exception.CustomException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {
    @Before("execution(* com.example.controller.EmployeeController.addEmployee(..)) && args(dtoToEmployee)")
    public void validateAddEmployee(Object dtoToEmployee) {
        if (dtoToEmployee == null) {
            throw new CustomException("Data Can not be NULL while adding");
        }
    }
}
