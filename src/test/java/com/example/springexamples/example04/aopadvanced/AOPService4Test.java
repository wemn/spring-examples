package com.example.springexamples.example04.aopadvanced;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AOPService4Test {
    @Autowired
    private AOPService4 aopService4;
    @Test
    public void getName() {
        log.debug(aopService4.getName("BO"));
    }
}