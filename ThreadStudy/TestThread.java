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

        for (int i = 0; i < 20; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}
