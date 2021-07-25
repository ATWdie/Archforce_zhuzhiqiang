package ThreadStudy.method.p7interrupt;

public class SubThread7 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            //判断线程的中断标志，线程有 isInterrupted() 方法，该方法返回线程的中断标志
            if(this.isInterrupted()){
                System.out.println("当前线程的中断标志为true，退出");
                break;
            }
            System.out.println("sub thread6-->" + i);
        }
    }
}
