package ThreadStudy.method.p4getid;

public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ",id=" + Thread.currentThread().getId());

        for (int i = 0; i < 20; i++) {
            new SubThread5().start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
