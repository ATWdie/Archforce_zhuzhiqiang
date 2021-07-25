package ThreadStudy.TestSyn;

//不安全的取钱
public class UnsafeBank {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100, "钱");

        Drawing d1 = new Drawing(account, 50, "A");
        Drawing d2 = new Drawing(account, 100, "B");

        d1.start();
        d2.start();

    }
}

//账户
class Account{
    private int money; //余额
    private String name; //

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Drawing extends Thread{
    Account account; //账户
    //取的钱数
    private int drawingMoney;
    //手里的钱数
    private int nowMoney;

    public Drawing(Account account, int drawingMoney, String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //取钱
    @Override
    public void run() {

        //锁的对象就是变化的量，需要增删改的对象
        synchronized (account){
            //判断有没有钱
            if(account.getMoney() <= 0){
                System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
                return;
            }

            //sleep可以放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //卡内余额
            account.setMoney(account.getMoney() - drawingMoney);
            //手里的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.getName() + "余额为：" + account.getMoney());
            System.out.println(Thread.currentThread().getName() + "手里的钱" + nowMoney);
        }
    }
}
