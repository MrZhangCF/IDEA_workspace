package com.zhangcf.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Subject1 {
    @Autowired
    private Subject2 subject2;

    public void doSomething(){
        subject2.function();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/zhangcf/config/applicationContext.xml");
        Subject1 subject1 = (Subject1) applicationContext.getBean("subject1");
        subject1.doSomething();
        String str = "123";
        Map map = new HashMap();
        map.put(null,"zhangcf");

    }
}
