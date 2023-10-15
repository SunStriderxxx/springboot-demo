package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * @author Fcb
 * @date 2020/3/11
 * @description
 */
@Service("B")
public class SecondStrategyService implements StrategyService {

    @Override
    public void run() {
        System.out.println("Second");
    }


}
