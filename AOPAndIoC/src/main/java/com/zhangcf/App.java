package com.zhangcf;

import com.zhangcf.aop.Say;
import com.zhangcf.aop.SayHello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/zhangcf/config/applicationContext.xml");
//        Say say = (Say) context.getBean("say");
//        say.say();
        Say say = (Say) context.getBean("say");
        say.say();
    }
}
