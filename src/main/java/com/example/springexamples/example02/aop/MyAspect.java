package com.example.springexamples.example02.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.example.springexamples.example02.aop..*.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void beforeAdvice() {
        log.debug("beforeAdvice");
    }
    @AfterReturning(("pointcut()"))
    public void afterRunningAdvice() {
        log.debug("afterReturningAdvice");
    }
    @After(("pointcut()"))
    public void afterAdvice() {
        log.debug("afterAdvice");
    }
    @Around(("pointcut()"))
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.debug("before aroundAdvice");
        Object object = joinPoint.proceed();
        log.debug("after aroundAdvice");
        return object;
    }
}
