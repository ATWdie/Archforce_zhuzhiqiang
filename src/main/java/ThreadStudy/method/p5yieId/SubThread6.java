package ThreadStudy.method.p5yieId;

public class SubThread6 extends Thread {
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 100000000; i++) {
            sum += i;
            Thread.yield();  //线程让步，放弃CPU执行权
        }
        long end = System.currentTimeMillis();

        System.out.println("用时:" + (end - begin));
    }
}
