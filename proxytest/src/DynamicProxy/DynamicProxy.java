package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

interface Subject{
    void request();
    void request2();
}

class RealSubject implements Subject{
    private int age;

    public int getAge() {
        System.out.println("age : " + this.age);
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void request() {
        System.out.println("RealSubject");
        request2();
    }

    @Override
    public void request2() {
        System.out.println("RealSubject2");
    }

}

class ProxyHandler implements InvocationHandler {
    private Object subject;
    public ProxyHandler(Object subject){
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> cls = subject.getClass();
        Method method1 = cls.getDeclaredMethod("getAge");
        int age = (int) method1.invoke(subject);
        if (age < 18){
            System.out.println("18岁以下禁止入内");
            return null;
        }

        if (method.getName().equals("request2")){
            return null;
        }else {
            System.out.println("before invoke");
            method.invoke(subject, args);
            System.out.println("after invoke");
        }
        return null;
    }
}

public class DynamicProxy{



    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        realSubject.setAge(68);
        ProxyHandler proxyHandler = new ProxyHandler(realSubject);
        Subject proxySubject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),proxyHandler);
        proxySubject.request();
        System.out.println(proxySubject.getClass().getName());
        //proxySubject.request2()
    }
}
