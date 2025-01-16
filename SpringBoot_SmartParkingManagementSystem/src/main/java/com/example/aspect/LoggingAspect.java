//package com.example.aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//@Aspect
//public class LoggingAspect {
//
////    @Before("execution(* com.example.controller.*.*(..))")
////    public void logBeforeMethod(JoinPoint joinPoint) {
////        log.info("Entering method : {} , with argument : {}", joinPoint.getSignature(), joinPoint.getArgs());
////    }
////
////    @AfterReturning(pointcut = "execution(* com.example.controller.*.*(..))", returning = "result")
////    public void logAfterMethod(JoinPoint joinPoint, Object result) {
////        log.info("Existing method : {} , with result : {}", joinPoint.getSignature(), result);
////    }
////
////    @AfterThrowing(pointcut = "execution(* com.example.controller.*.*(..))", throwing = "exception")
////    public void logException(JoinPoint joinPoint, Throwable exception) {
////        log.error("Exception in method : {} , with message : {}", joinPoint.getSignature(), exception.getMessage());
////    }
//}
