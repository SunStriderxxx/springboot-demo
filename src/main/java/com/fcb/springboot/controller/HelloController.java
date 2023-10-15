package com.fcb.springboot.controller;

import com.fcb.springboot.aspect.anno.MyLog;
import com.fcb.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fcb
 * @date 2020/3/11
 * @description
 */
@RestController
@MyLog
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(String a){
        System.out.println(a);
        return "hello spring";
    }

    @GetMapping("/findUser")
    public String findUser(Long userId){
        System.out.println(userId);
        return userService.getUserById(userId).toString();
    }
}
