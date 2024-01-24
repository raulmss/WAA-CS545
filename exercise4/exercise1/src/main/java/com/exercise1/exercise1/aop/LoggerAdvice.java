package com.exercise1.exercise1.aop;

import com.exercise1.exercise1.entity.aop.Logger;
import com.exercise1.exercise1.repo.LoggerRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;

@Aspect
@Configuration
public class LoggerAdvice {

    @Autowired
    private LoggerRepo loggerRepo;

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExecutionTime {
    }

    @Pointcut("@annotation(com.exercise1.exercise1.aop.LoggerAdvice.ExecutionTime)")
    public void ExecutionTimePointcut() {
    }

    @Around("ExecutionTimePointcut()")
    public Object logAfterGetUserById(ProceedingJoinPoint call) throws Throwable{
        StopWatch sw = new StopWatch("");
        sw.start(call.getSignature().getName());

        Object retVal = call.proceed();
        sw.stop();

        Logger loger = new Logger();
        loger.setDate(LocalDate.now());
        loger.setTime(sw.getLastTaskTimeMillis());
        loger.setPrincipal("Standard User");
        loger.setOperation(call.getSignature().getName());
        loggerRepo.save(loger);

        long totalTime = sw.getLastTaskTimeMillis();
        System.out.println("Total time used for this operation \""+ call.getSignature().getName()+"\"  was: "+totalTime +"ms");

        return retVal;
    }
}
