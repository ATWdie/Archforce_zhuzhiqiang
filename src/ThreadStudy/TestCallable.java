package ThreadStudy;

import java.util.concurrent.*;

//线程创建方式三：实现Callable接口
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url, String name){
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public Boolean call(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载的文件名为: " + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://img2.baidu.com/it/u=3448210393,2234757647&fm=26&fmt=auto&gp=0.jpg", "1.jpg");
        TestCallable t2 = new TestCallable("https://img0.baidu.com/it/u=4084129530,3438713827&fm=26&fmt=auto&gp=0.jpg", "2.jpg");
        TestCallable t3 = new TestCallable("https://img1.baidu.com/it/u=2893615075,2492346271&fm=26&fmt=auto&gp=0.jpg", "3.jpg");

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = service.submit(t1);
        Future<Boolean> r2 = service.submit(t2);
        Future<Boolean> r3 = service.submit(t3);

        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        //关闭服务
        service.shutdown();
    }
}
