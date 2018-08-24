package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test extends Proxy implements Subject {

    /**
     * Constructs a new {@code Proxy} instance from a subclass
     * (typically, a dynamic proxy class) with the specified value
     * for its invocation handler.
     *
     * @param h the invocation handler for this proxy instance
     * @throws NullPointerException if the given invocation handler, {@code h},
     *                              is {@code null}.
     */
    protected Test(InvocationHandler h) {
        super(h);
    }

    @Override
    public void request() {
        System.out.println("1");
    }

    @Override
    public void request2() {
        System.out.println("2");
    }

    public static void main(String[] args) {
        new Test(new Handler(new RealSubject())).request();
    }
}

class Handler implements InvocationHandler{
    private Object object;
    public Handler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("3");
        return null;
    }
}
