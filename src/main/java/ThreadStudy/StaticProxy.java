package ThreadStudy;

/*
静态代理模式总结：
真实对象和代理模式都要实现同一个接口
代理对象要代理真实角色

好处：
代理对象可以做很多真实对象做不了的操作
真实对象可以专注做自己的事情
 */
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.happyMarry();
    }
}

interface Marry{
    void happyMarry();
}

//真实角色
class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("Happy Marry!");
    }
}

//代理角色
class WeddingCompany implements Marry{

    private Marry targetPerson;

    public WeddingCompany(Marry targetPerson) {
        this.targetPerson = targetPerson;
    }

    @Override
    public void happyMarry() {
        before();
        this.targetPerson.happyMarry();
        after();
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}