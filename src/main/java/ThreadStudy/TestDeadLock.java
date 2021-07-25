package ThreadStudy;

//死锁
public class TestDeadLock {
    public static void main(String[] args) {
        MakeUp m1 = new MakeUp(0, "A");
        MakeUp m2 = new MakeUp(1, "B");

        m1.start();
        m2.start();
    }
}

//口红
class Lipstick{

}

//镜子
class Mirror{

}

class MakeUp extends Thread {
    //需要的资源只有一份，用static来保证
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    public int choice; //选择
    public String name; //姓名

    public MakeUp(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeUp() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.name + "获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror) { //一秒钟后想获得镜子的锁
                System.out.println(this.name + "获得镜子的锁");
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.name + "获得镜子的锁");
                Thread.sleep(2000);
            }
            synchronized (lipstick) { //一秒钟后想获得镜子的锁
                System.out.println(this.name + "获得口红的锁");
            }
        }
    }
}
