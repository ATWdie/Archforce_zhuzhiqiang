package ThreadStudy.method.p8daemon;

public class SubDeamonThread extends Thread{
    @Override
    public void run() {
        super.run();
        while (true){
            System.out.println("Sub thread.....");
        }
    }
}
