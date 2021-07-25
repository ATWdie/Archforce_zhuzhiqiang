package ThreadStudy.method.p8daemon;

/**
 * 设置线程为守护线程
 * @author zzq
 */
public class Test {
    public static void main(String[] args) {
        SubDeamonThread thread = new SubDeamonThread();

        //设置线程为守护线程
        //设置守护线程的代码应该在线程启动前
        thread.setDaemon(true);
        thread.start();

        //当前线程为main线程
        for (int i = 0; i < 10; i++) {
            System.out.println("main==" + i);
        }
    }
}
