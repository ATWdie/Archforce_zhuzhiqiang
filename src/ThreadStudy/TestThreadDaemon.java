package ThreadStudy;

//测试守护线程
public class TestThreadDaemon {
    public static void main(String[] args) {
        God god = new God();
        YouLive you = new YouLive();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认false是用户线程，正常的线程都是用户线程

        thread.start(); //daemon thread start

        new Thread(you).start(); //user thread start
    }
}

//God
class God implements Runnable{
    @Override
    public void run() {
        System.out.println("God");
    }
}

//You
class YouLive implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("happy");
        }
        System.out.println("goodbye");
    }
}

