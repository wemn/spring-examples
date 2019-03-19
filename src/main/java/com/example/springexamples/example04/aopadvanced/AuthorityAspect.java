package com.example.springexamples.example04.aopadvanced;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@Aspect
public class AuthorityAspect {
    // 任何包含MyAuthority注释的类或方法，顺序必须是先判断方法再判断类型
    @Around("@within(myAuthority) || @annotation(myAuthority)")
    public Object interecptorTarget(ProceedingJoinPoint joinpoint, MyAuthority myAuthority) throws Throwable {
        // 如果是类型注释
        Optional.ofNullable(myAuthority)
                // 类型注释@annotation(myAuthority)会将myAuthority参数至空，因此需反射获取类注释
                .or(() -> {
                    MyAuthority m =
                            joinpoint.getTarget().getClass().getAnnotation(MyAuthority.class);
                    return Optional.of(m);
                })
                // 比较用户实际权限
                .ifPresent(m -> {
                    for (MyAuthority.MyAuthorityType t : m.value()) {
                        // 比较用户实际权限
                        log.debug("{}", t);
                    }
                });
        return joinpoint.proceed();
    }
}
