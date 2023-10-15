package com.example.demo.controller;

import com.example.demo.component.AComponent;
import com.example.demo.enumeration.TestEnum;
import com.example.demo.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fcb
 * @date 2020/3/11
 * @description
 */
@RestController
public class HelloController {

    @Autowired
    AComponent aComponent;

    @Resource
    Map<String, StrategyService> map;

    @GetMapping("/hello")
    public String hello(String a){
        System.out.println(a);
        for (String s : map.keySet()) {
            System.out.println(s);
            StrategyService strategyService = map.get(TestEnum.A.name());
            strategyService.run();
        }
        return "hello spring";
    }
}
