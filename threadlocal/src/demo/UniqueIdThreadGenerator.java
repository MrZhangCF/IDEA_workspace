package demo;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIdThreadGenerator {
    //private static final AtomicInteger uniqueId = new AtomicInteger(0);
    private static final ThreadLocal<Integer> uniqueNum = ThreadLocal.withInitial(()->new AtomicInteger(1).get());

    public static int getUniqueId(){
        uniqueNum.set(uniqueNum.get() + 1);
        return uniqueNum.get();
    }

    public static void main(String[] args) {
        UniqueIdThreadGenerator uniqueIdThreadGenerator = new UniqueIdThreadGenerator();
        TaskThread t1 = new TaskThread<>("thread-1",uniqueIdThreadGenerator);
        TaskThread t2 = new TaskThread<>("thread-2",uniqueIdThreadGenerator);
        t1.start();
        t2.start();
    }
}
