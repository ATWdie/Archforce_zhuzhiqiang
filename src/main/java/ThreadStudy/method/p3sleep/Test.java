package ThreadStudy.method.p3sleep;

public class Test {
    public static void main(String[] args) {
        SubThread4 t4 = new SubThread4();
        System.out.println("main_begin = " + System.currentTimeMillis());
        t4.start();
        System.out.println("main_end = " + System.currentTimeMillis());
    }
}
