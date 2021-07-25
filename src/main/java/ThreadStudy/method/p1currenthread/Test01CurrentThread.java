package ThreadStudy.method.p1currenthread;

public class Test01CurrentThread {
    public static void main(String[] args) throws InterruptedException {
        //创建子线程对象
        SubThreadCurrent s1 = new SubThreadCurrent();
        s1.setName("s1");
        s1.start();

        Thread.sleep(500);

        //Thread(Runnable)构造方法形参书Runnable接口，调用时传递的实参是接口的实现类对象
        Thread t1 = new Thread(s1);
        t1.start();
    }
}
