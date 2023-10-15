package com.fcb.springboot.config;

import com.fcb.springboot.component.AComponent;
import com.fcb.springboot.component.CComponent;
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
