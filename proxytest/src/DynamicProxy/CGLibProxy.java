package DynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class HelloConcrete{
    public String sayHello(String str){
        return "HelloConcrete: " + str;
    }
}

class MyMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //System.out.println("class of o : " + o.getClass());
        System.out.println("here is interceptor");

        return methodProxy.invokeSuper(o, objects);
    }
}

public class CGLibProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());

        HelloConcrete helloConcrete = (HelloConcrete) enhancer.create();
        System.out.println(helloConcrete.sayHello(" I love U"));
        System.out.println(helloConcrete.getClass().getName());
        System.out.println(helloConcrete.getClass().getSuperclass().getName());
//        enhancer.setInterfaces(new Class[]{Subject.class});
//        enhancer.setCallback(new MyMethodInterceptor());
//        Subject subject = (Subject) enhancer.create();
//        subject.request();
    }
}
