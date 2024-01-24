package edu.miu.springsecurity1.aspect;



import edu.miu.springsecurity1.service.ProductService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    ProductService productService;

    @Pointcut("@annotation(edu.miu.springsecurity1.aspect.annotation.LogMe)")
    public void logMeAnnotation(){

    }

    @Before(" logMeAnnotation()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Log before the method: " + joinPoint.getSignature().getName());
    }







}
