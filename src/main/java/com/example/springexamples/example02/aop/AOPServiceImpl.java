package com.example.springexamples.example02.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class AOPServiceImpl implements AOPService {
    @Override
    public void get() {
        log.debug("AOPServiceImpl.get()");
    }
}
