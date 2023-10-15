package com.fcb.springboot.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Fcb
 * @date 2021/11/19
 * @description
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        context.close();
    }
}
