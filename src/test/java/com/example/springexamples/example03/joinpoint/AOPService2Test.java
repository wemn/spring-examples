package com.example.springexamples.example03.joinpoint;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AOPService2Test {
    @Autowired
    private AOPService2 aopService2;
    @Test
    public void beforeTest() {
        aopService2.welcome("BO");
    }
    @Test
    public void aroundTest() {
        log.debug(aopService2.welcome("BO"));
    }

}