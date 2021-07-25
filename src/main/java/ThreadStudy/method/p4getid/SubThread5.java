package ThreadStudy.method.p4getid;

public class SubThread5  extends Thread{
    @Override
    public void run() {
        System.out.println("thread name = " + Thread.currentThread().getName()
                        + ",id=" + this.getId());
    }
}
