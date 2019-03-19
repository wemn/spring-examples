package com.example.springexamples.example03.joinpoint;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class MyAspect2 {
    @Pointcut("execution(* com.example.springexamples.example03..*.*(..))")
    public void pointcut() {}
    // @Before("pointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        Arrays.asList(joinPoint.getArgs())
                .forEach(arg -> {
                    log.debug("arg: " + arg);
                });
        log.debug("getTarget(): {}", joinPoint.getTarget().getClass().getSimpleName());
        log.debug("getThis(): {}", joinPoint.getThis().getClass().getSimpleName());
    }

    @Around(("pointcut()"))
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String name = (String) args[0];
        if ("BO".equals(name)) {
            args[0] = "SUN";
        }
        Object object = joinPoint.proceed(args);
        log.debug("连接点方法返回类型: {}", object.getClass().getSimpleName());
        return  object;
    }
}
