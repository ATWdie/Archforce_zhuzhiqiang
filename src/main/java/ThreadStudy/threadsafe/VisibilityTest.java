package ThreadStudy.threadsafe;

import java.util.Random;

/**
 * 测试线程的可见性
 * @author zhuzhiqiang
 */
public class VisibilityTest {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        new Thread(task).start();

        Thread.sleep(1000);
        task.cancel();
        /*
                可能会出现以下情况:
                    在 main 线程中调用了 task.cancel() 方法，把 task 对象的 toCancel 变量修改为 true，
                    可能存在子线程看不到 main 线程对 toCancel 做的修改，在子线程中 toCancel 一直为 false
                导致子线程看不到 main 线程对 toCancel 变量修改的原因可能有：
                    1）JIT 即时编译器可能会对 run 方法中的 while 循环进行优化为：
                        if(!toCancel){
                            while (!toCancel){
                                   if(doSomething()){
                                }
                            }
                        }
                   2）可能与计算机的存储系统有关，假设分别有两个 CPU 内核运行 main 线程与子线程，
                   运行子线程的 CPU 无法立即读取运行 main 线程 CPU 中的数据
         */
    }

    static class MyTask implements Runnable{
        private boolean toCancel = false;

        @Override
        public void run() {
            while (!toCancel){
                if(doSomething()){
                }
            }
            if (toCancel){
                System.out.println("任务被取消");
            } else {
                System.out.println("任务正常结束");
            }
        }

        private boolean doSomething(){
            System.out.println("执行某个任务........");
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }

        public void cancel(){
            toCancel = true;
            System.out.println("收到取消线程的消息");
        }
    }
}
