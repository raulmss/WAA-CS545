package com.exercise1.exercise1.aop;

import com.exercise1.exercise1.entity.aop.ExceptionLogger;
import com.exercise1.exercise1.repo.ExceptionLoggerRepo;
import com.exercise1.exercise1.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Aspect
@Configuration
public class ExceptionLoggerAdvice {
    @Autowired
    private ExceptionLoggerRepo exceptionLoggerRepo;

    @AfterThrowing(pointcut = "execution(* com.exercise1.exercise1.*.*.*(..))", throwing = "exception")
    public void logAfterThrowingAllMethods(JoinPoint joinPoint, Exception exception) throws Throwable {
        ExceptionLogger exceptionLogger = new ExceptionLogger();
        exceptionLogger.setDate(LocalDate.now());
        exceptionLogger.setPrincipal("Standard User");
        exceptionLogger.setOperation(joinPoint.getSignature().getName());
        exceptionLogger.setExceptionType(exception.getClass().getName());
        exceptionLogger.setExceptionMessage(exception.getMessage());
        exceptionLoggerRepo.save(exceptionLogger);

    }
}
