package demo;

interface Subject{
    public void request();
}

class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("海景房，100万");
    }
}

class Proxy implements Subject {

    private RealSubject realSubject = null;

    @Override
    public void request() {
        preRequest();

        if (realSubject == null){
            realSubject = new RealSubject();
        }
        realSubject.request();

        postRequest();
    }

    private void postRequest() {
        System.out.println("卖房成功");
    }

    private void preRequest() {
        System.out.println("现有海景房一套，150万");
    }
}

public class StaticProxy {
    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.request();
    }
}
