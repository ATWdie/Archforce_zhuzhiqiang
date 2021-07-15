package ThreadStudy;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//联系Thread，实现多线程同步下载图片
public class TestThread1 extends Thread{
    private String url;
    private String name;

    public TestThread1(String url, String name){
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载的文件名为: " + name);
    }

    public static void main(String[] args) {
        TestThread1 t1 = new TestThread1("https://img2.baidu.com/it/u=3448210393,2234757647&fm=26&fmt=auto&gp=0.jpg", "1.jpg");
        TestThread1 t2 = new TestThread1("https://img0.baidu.com/it/u=4084129530,3438713827&fm=26&fmt=auto&gp=0.jpg", "2.jpg");
        TestThread1 t3 = new TestThread1("https://img1.baidu.com/it/u=2893615075,2492346271&fm=26&fmt=auto&gp=0.jpg", "3.jpg");

        //启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class WebDownloader{
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法异常");
        }
    }
}
