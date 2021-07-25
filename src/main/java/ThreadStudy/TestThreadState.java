package ThreadStudy;

//观察测试线程状态
public class TestThreadState {
    public static void main(String[] args) throws InterruptedException {
        //线程体
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("/////////");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);

        //观察启动后
        thread.start(); //启动线程
        state = thread.getState(); //更新状态
        System.out.println(state); //Run

        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }

        thread.start(); //死亡后的线程不能再次启动
    }
}
