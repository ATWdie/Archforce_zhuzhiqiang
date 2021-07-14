/*
    Author:zhuzhiqiang
    Time:2021/7/14
    继承 demo
 */

class SuperClass{
    private int n;
    SuperClass(){
        System.out.println("SuperClass()");
    }
    SuperClass(int n){
        System.out.println("SuperClass(int n)");
    }
}

//SubClass 继承类
class SubClass extends SuperClass{
    private int n;

    SubClass(){
        System.out.println("SubClass");
    }
    public SubClass(int n){
        super(300);
        System.out.println("SubClass(int n):" + n);
        this.n = n;
    }
}

//SubClass2 继承类
class SubClass2 extends SuperClass{
    private int n;

    SubClass2(){
        super(300);
        System.out.println("SubClass2");
    }

    public SubClass2(int n){
        System.out.println("SubClass2(int n):" + n);
        this.n = n;
    }
}
public class ExtendsStudy {
    public static void main(String[] args){
        SubClass subClass = new SubClass();
        SubClass subClass1 = new SubClass(100);
        System.out.println("-----------------------------");
        SubClass2 subClass2 = new SubClass2();
        SubClass2 subClass3 = new SubClass2(200);
    }
}
