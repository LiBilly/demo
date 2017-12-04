package com.example.demo.core;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Before;
import org.springframework.context.annotation.Configuration;

/**
 * Created by billy on 17-12-4.
 */
@Aspect
@Configuration
public class WebElementAop {

    @Pointcut("execution(* com.example.demo.MyWebElement.*(..))")
    private void allWebElementMethods() {}

    @Around("allWebElementMethods()")
    private Object findTargetElement(ProceedingJoinPoint joinPoint) throws Throwable {
        Object target = joinPoint.getTarget();
        System.out.print(target.getClass());
        return joinPoint.proceed();
    }
}
