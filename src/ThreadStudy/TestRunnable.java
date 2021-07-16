package ThreadStudy;

//创建线程方式2：实现 runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
public class TestRunnable implements Runnable{
    @Override
    public void run(){
        //run 方法载体
        for (int i = 0; i < 20; i++) {
            System.out.println("Run Thread: " + i);
        }
    }

    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        TestRunnable testRunnable = new TestRunnable();
        //创建线程对象，通过线程对象开启线程，代理
        new Thread(testRunnable).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("Main Thread: " + i);
        }
    }
}
