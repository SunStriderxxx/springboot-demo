package com.fcb.springboot.aspect;

import com.fcb.springboot.aspect.anno.MyLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Fcb
 * @date 2020/6/20
 * @description 切面类=切入点+通知
 */
@Aspect
@Component
public class LogAspect {

    //这个方法定义了切入点
    @Pointcut("@within(com.fcb.springboot.aspect.anno.MyLog)")
    public void pointCut() {}

    //这个方法定义了具体的通知
    @After("pointCut()")
    public void recordRequestParam(JoinPoint joinPoint) {
        MyLog annotation = joinPoint.getTarget().getClass().getAnnotation(MyLog.class);
        System.out.println(annotation.annotationType());
        System.out.println(annotation.value());
        for (Object s : joinPoint.getArgs()) {
            //打印所有参数，实际中就是记录日志了
            System.out.println("after advice : " + s);
        }
    }

    //这个方法定义了具体的通知
    @Before("pointCut()")
    public void startRecord(JoinPoint joinPoint) {
        for (Object s : joinPoint.getArgs()) {
            //打印所有参数
            System.out.println("before advice : " + s);
        }
    }

    //这个方法定义了具体的通知
    @Around("pointCut()")
    public Object aroundRecord(ProceedingJoinPoint pjp) throws Throwable {
        for (Object s : pjp.getArgs()) {
            //打印所有参数
            System.out.println("around advice : " + s);
        }
        return pjp.proceed();
    }
}
