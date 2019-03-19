package com.example.springexamples.example04.aopadvanced;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class MyAspect4 {
    @Pointcut("execution(* com.example.springexamples." +
            "example04.aopadvanced.AOPService4.get*(..))")
    public void pointcut() {}

    @Around(("pointcut()"))
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object object = joinPoint.proceed();
        long end = System.nanoTime();
        log.debug("执行时间：{}", end - start);
        return  object;
    }
    //-----------------------------------

}
