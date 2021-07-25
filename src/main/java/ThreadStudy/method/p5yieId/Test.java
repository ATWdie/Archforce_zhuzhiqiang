package ThreadStudy.method.p5yieId;

public class Test {
    public static void main(String[] args) {
        SubThread6 t6 = new SubThread6();
        t6.start();

        long begin = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 100000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();

        System.out.println("用时:" + (end - begin));
    }
}
