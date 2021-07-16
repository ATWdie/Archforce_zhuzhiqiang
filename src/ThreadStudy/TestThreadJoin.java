package ThreadStudy;


//Join合并线程，待此线程执行完成后，再执行其它线程，其它线程阻塞
//等同与插队
public class TestThreadJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程VIP来了: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动线程
        TestThreadJoin testThreadJoin = new TestThreadJoin();
        Thread thread = new Thread(testThreadJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 1000; i++) {
            if(i==200){
                thread.join();
            }
            System.out.println("main: " + i);
        }
    }
}
