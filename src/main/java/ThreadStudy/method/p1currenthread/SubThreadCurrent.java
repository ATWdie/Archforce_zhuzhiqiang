package ThreadStudy.method.p1currenthread;

public class SubThreadCurrent extends Thread {
    public SubThreadCurrent(){
        System.out.println("构造方法中,Thread.currentThread().getName():" + Thread.currentThread().getName());
        System.out.println("构造方法,this.getName():" + this.getName());
    }

    @Override
    public void run() {
        System.out.println("run方法中,Thread.currentThread().getName():" + Thread.currentThread().getName());
        System.out.println("run方法,this.getName():" + this.getName());
    }
}
