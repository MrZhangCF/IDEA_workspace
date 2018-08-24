package com.zhangcf.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BeforeSay {

    @Pointcut("execution(* com.zhangcf.aop.SayHello.*(..))")
    private void pointCutMethod(){}

    @Before("pointCutMethod()")
    public void beforeSay(){
        System.out.println("说之前");
    }
}
