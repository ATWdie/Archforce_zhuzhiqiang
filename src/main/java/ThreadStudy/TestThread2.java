package ThreadStudy;

//多个线程同时操作同一个对象
//发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱
public class TestThread2 implements Runnable{

    //票数
    private int ticketNumber = 10;

    @Override
    public void run(){
        while (true){
            if(ticketNumber <= 0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->拿到了第" + ticketNumber-- + "票");
        }
    }
    public static void main(String[] args) {
        TestThread2 ticket = new TestThread2();

        new Thread(ticket, "A").start();
        new Thread(ticket, "B").start();
        new Thread(ticket, "C").start();
    }
}
