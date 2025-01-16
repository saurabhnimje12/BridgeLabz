package com.example.aspect;

import com.example.exception.CustomiseException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {
    @Before("execution(* com.example.controller.*.*(..)) && args(dtoToEmployee)")
    public void validateAddEmployee(Object dtoToEmployee) {
        if (dtoToEmployee == null) {
            throw new CustomiseException("Data Can not be NULL while adding");
        }
    }
}
