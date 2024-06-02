package edu.miu.lab4.Aop;

import edu.miu.lab4.Entity.Logger;
import edu.miu.lab4.Repository.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    private LoggerRepo loggerRepo;

    @Pointcut("execution(public * edu.miu.lab4.Service.*.*(..))")
    private void logger(){

    }

    @After("logger()")
    public void afterMethodLog(JoinPoint joinPoint){
        Logger logger = new Logger();
        LocalDate date = LocalDate.now();
        LocalDateTime time = LocalDateTime.now();
        String operation = joinPoint.getSignature().getName();
        logger.setDate(date);
        logger.setTime(time);
        logger.setOperation(operation);
        loggerRepo.save(logger);
    }
}
