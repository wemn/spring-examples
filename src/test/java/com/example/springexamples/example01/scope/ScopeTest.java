package com.example.springexamples.example01.scope;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ScopeTest {
    @Autowired
    private PrototypeBean prototypeBean;
    @Autowired
    private SingletonBean singletonBean;
    @Test
    public void test() {
        log.debug("prototype in test: {}", prototypeBean);
        log.debug("singleton in test: {}", singletonBean);
        prototypeBean.getSingle();
        singletonBean.getProto();
    }

}