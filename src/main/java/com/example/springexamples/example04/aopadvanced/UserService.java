package com.example.springexamples.example04.aopadvanced;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@MyAuthority
public class UserService {
    @MyAuthority(value = MyAuthority.MyAuthorityType.ADMIN)
    public void addUser() {
        log.debug("管理员权限");
    }
    public void getUser() {
        log.debug("普通用户权限");
    }
}
