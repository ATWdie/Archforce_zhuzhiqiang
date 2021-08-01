package ThreadStudy.threadsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程的原子性问题
 * @author zhuzhiqiang
 */
public class AtomicTest01 {
    public static void main(String[] args) {
        MyInt2 myInt = new MyInt2();

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                 while (true){
                     System.out.println(Thread.currentThread().getName() + "---->" + myInt.getNum());
                     try {
                         Thread.sleep(100);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                }
            }).start();
        }
    }

    static class MyInt1{
        int num;

        public int getNum() {
            return num++;
        }
    }

    /**
     * Java 中提供了一个线程安全的 AtomicInteger 类，保证了操作的原子性
     */
    static class MyInt2{
        AtomicInteger num = new AtomicInteger();

        public int getNum() {
            return num.getAndIncrement();
        }
    }
}
