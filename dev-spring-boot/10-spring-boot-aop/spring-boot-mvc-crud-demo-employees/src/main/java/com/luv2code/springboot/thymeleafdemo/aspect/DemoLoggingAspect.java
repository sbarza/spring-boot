package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // Setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // Setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    public void forControllerPackage() {}

    // Do the same for service and dao
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    public void forServicePackage() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void forAppFlow() {}

    // Add @Before Advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {

        // Display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=====>> in @Before: calling method: " + theMethod);

        // Display the arguments to the method

        // Get the arguments
        Object[] args = theJoinPoint.getArgs();

        // Loop through and display arguments
        for (Object tempArg : args) {
            myLogger.info("=====>> argument: " + tempArg);
        }
    }

}
