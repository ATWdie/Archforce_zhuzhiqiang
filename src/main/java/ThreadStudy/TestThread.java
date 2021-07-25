package ThreadStudy;

// 创建线程方式一：继承 Thread 类，重写 run()方法，调用 start 开启线程
public class TestThread extends Thread {
    @Override
    public void run(){
        //run 方法载体
        for (int i = 0; i < 20; i++) {
            System.out.println("Run Thread: " + i);
        }
    }

    public static void main(String[] args) {
        //main 线程，主线程

        //创建一个线程对象
        TestThread testThread1 = new TestThread();

        //调用start()启动线程
        testThread1.start();
        /*
            调用线程的start()方法来启动线程，启动线程的实质就是请求JVM运行相应的线程，这个线程具体在什么时候运行由线程调度器(Scheduler)决定
            注意：
                start()方法调用结束并不意味着子线程开始运行
                新开期的线程会执行run()方法
                如果开启了多个线程，start()调用的顺序并不一定就是线程启动的顺序
                多线程运行结果与代码执行顺序或者调用顺序无关
        */

        for (int i = 0; i < 20; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}
