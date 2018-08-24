package demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class MyInvocationHandler implements InvocationHandler{

    private Object houseHolder;

    public MyInvocationHandler(Object object){
        this.houseHolder = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("现有房源，欢迎选购！");
        //jack.sale();
        method.invoke(houseHolder,args);
        System.out.println("恭喜这位爷！");
        System.out.println("成功卖出，收取佣金10%，美滋滋！");
        return null;
    }
}

public class Market2 {
    public static void main(String[] args) {
        HouseOfJack houseOfJack = new HouseOfJack();
        System.out.println("老子有钱，要买房");
        MyInvocationHandler saleProxy = new MyInvocationHandler(houseOfJack);
        HouseSale houseSale = (HouseSale) Proxy.newProxyInstance(houseOfJack.getClass().getClassLoader(), houseOfJack.getClass().getInterfaces(), saleProxy);
        houseSale.sale();
    }
}
