package com.zhangcf.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AfterSay {

    @Pointcut("execution(* com.zhangcf.aop.SayHello.*(..))")
    private void pointCutMethod(){}

    @After("pointCutMethod()")
    public void afterSay(){
        System.out.println("说之后");
    }
}
