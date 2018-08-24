package DynamicProxy;

class FTest{
    public void f(){
        System.out.println("f method");
    }

    public void g(){
        System.out.println("g method");
    }
}

class FFTest{
    public Object invoke(int index, Object o, Object[] ol){
        FTest t = (FTest) o;
        switch (index){
            case 1:
                t.f();
                return null;
            case 2:
                t.g();
                return null;
        }
        return null;
    }

    public int getIndex(String signature){

        switch (signature.hashCode()){
            case 3078479:
                return 1;
            case 3108270:
                return 2;
        }
        return -1;
    }
}

public class FastTest {
    public static void main(String[] args) {
        FTest test = new FTest();
        FFTest ffTest = new FFTest();
        int indexOff = ffTest.getIndex("f()V");
        ffTest.invoke(indexOff, test, null);
        int indexOfg = ffTest.getIndex("g()V");
        ffTest.invoke(indexOfg, test, null);

    }
}
