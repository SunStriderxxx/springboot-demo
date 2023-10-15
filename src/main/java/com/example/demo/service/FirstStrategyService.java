package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
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
