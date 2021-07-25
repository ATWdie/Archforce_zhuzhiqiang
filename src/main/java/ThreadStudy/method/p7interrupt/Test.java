package ThreadStudy.method.p7interrupt;

public class Test {
    public static void main(String[] args) {
        SubThread7 t7 = new SubThread7();
        t7.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main -->" + i);
        }

        //中断子线程
        t7.interrupt();  //子线程没有中断
    }
}
