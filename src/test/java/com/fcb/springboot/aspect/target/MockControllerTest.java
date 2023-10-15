package com.fcb.springboot.aspect.target;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author Fcb
 * @date 2020/6/20
 * @description￿￿￿
 */
@SpringBootTest
class MockControllerTest {

    @Autowired
    MockController mockController;

    @Test
    void helloAop() {
        String aop = mockController.helloAop("aop");
        System.out.println(aop);
    }
}