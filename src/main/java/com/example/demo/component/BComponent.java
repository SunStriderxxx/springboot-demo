package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Fcb
 * @date 2020/6/25
 * @description
 */
//@Component(value = "b")
//@Scope("prototype")
public class BComponent {

    @Autowired
    private AComponent aComponent;

}
