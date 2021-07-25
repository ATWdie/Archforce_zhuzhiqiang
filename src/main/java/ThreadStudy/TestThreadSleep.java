package ThreadStudy;

//每个对象都有一把锁，sleep不会释放锁
public class TestThreadSleep implements Runnable{

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
        TestThreadSleep ticket = new TestThreadSleep();

        new Thread(ticket, "A").start();
        new Thread(ticket, "B").start();
        new Thread(ticket, "C").start();
    }
}
