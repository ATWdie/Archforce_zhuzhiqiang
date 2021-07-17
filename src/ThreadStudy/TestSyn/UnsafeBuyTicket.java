package ThreadStudy.TestSyn;

//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "A").start();
        new Thread(buyTicket, "B").start();
        new Thread(buyTicket, "C").start();
    }
}

class BuyTicket implements Runnable{

    //票
    private int ticketNumbers = 10;
    boolean flag = true; //外部停止方式

    @Override
    public void run() {
        while (flag){
            try {
                Thread.sleep(100);
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void buy() throws InterruptedException {
        //判断是否有票
        if(ticketNumbers <= 0){
            flag = false;
            return;
        }

        //判断是否有票
        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNumbers--);
    }
}
