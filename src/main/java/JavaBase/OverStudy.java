package JavaBase;/*
    Author:zhuzhiqiang
    Time:2021/7/14
    重写/重载 demo
 */

//重写:子类对父类的实现过程进行重新编写，返回值和形参不变
//重载:一个类里面方法名相同，其它可以不同

class Animal{
    public void move(){
        System.out.println("动物可以移动");
    }
}

class Dog extends Animal{
    //重写 move 方法
    public void move(){
        super.move();
        System.out.println("狗可以跑和走");
    }

    //重载 test 方法
    public int test(){
        System.out.println("test1");
        return 1;
    }

    public void test(int a){
        System.out.println("test2: "+ a);
    }

    public String test(int a, String s){
        System.out.println("test3: "+ a + s);
        return "test3";
    }

    public String test(String s, int a){
        System.out.println("test4: " + s + a);
        return "test4";
    }
}

public class OverStudy {
    public static void main(String[] args){
        Animal animal = new Animal();
        Animal animal1 = new Dog();
        Dog dog = new Dog();

        animal.move();
        animal1.move();

        dog.test();
        dog.test(1);
        dog.test(1,"test3");
        dog.test("test4", 1);

    }
}
