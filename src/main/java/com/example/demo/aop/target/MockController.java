package com.example.demo.aop.target;

import com.example.demo.aop.anno.MyLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fcb
 * @date 2020/6/20
 * @description
 */
@MyLog(value = "aaa")
@RestController
public class MockController {


    @RequestMapping("/hello")
    public String helloAop(@RequestParam String key) {
        System.out.println("do something...");
        return "hello world";
    }

}
