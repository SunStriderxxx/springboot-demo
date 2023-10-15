package com.fcb.springboot.service;

import org.springframework.stereotype.Service;

/**
 * @author Fcb
 * @date 2020/3/11
 * @description
 */
@Service("A")
public class FirstStrategyService implements StrategyService {

    @Override
    public void run() {
        System.out.println("First");
    }

    public FirstStrategyService(){

    }
}
