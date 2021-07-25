package ThreadStudy.method.p3sleep;

import sun.awt.windows.ThemeReader;

/**
 * 使用sleep线程休眠完成简易计时器
 */
public class SimpleTimer {
    public static void main(String[] args) {
        int remaining = 10;
        if (args.length == 1){
            remaining = Integer.parseInt(args[0]);
        }

        while(true){
            System.out.println("Remaining:" + remaining);
            remaining--;
            if (remaining < 0){
                break;
            }
            try {
                Thread.sleep(1000); //线程休眠
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
