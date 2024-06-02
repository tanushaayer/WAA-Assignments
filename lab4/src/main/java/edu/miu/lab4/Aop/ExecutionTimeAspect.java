package edu.miu.lab4.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Aspect
@Component
public class ExecutionTimeAspect {

    @Pointcut("@annotation(edu.miu.lab4.Aop.ExecutionTimeAspect.ExecutionTime)")
    public void executionPointcut(){}

    @Around("executionPointcut()")
    public void executionAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long runtime = endTime - startTime;
        System.out.println("Run Time " + runtime + " ms");
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface ExecutionTime {

    }
}
