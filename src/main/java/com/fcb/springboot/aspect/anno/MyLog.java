package com.fcb.springboot.aspect.anno;

import java.lang.annotation.*;

/**
 * @author Fcb
 * @date 2020/6/20
 * @description
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MyLog {

    String value() default "";
}
