package com.example.demo.config;

import com.example.demo.component.AComponent;
import com.example.demo.component.CComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Fcb
 * @date 2021/11/19
 * @description
 */
@Configuration
@Import(value = CComponent.class)
public class TestConfig {

//    @Bean
//    public AComponent component1() {
//        return new AComponent();
//    }

    @Bean
    public AComponent component2() {
        return new AComponent();
    }
}
