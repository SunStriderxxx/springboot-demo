package com.example.demo.component;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Fcb
 * @date 2021/11/19
 * @description
 */
@Component
public class CComponent {

    @Resource
    private AComponent component1;
}
