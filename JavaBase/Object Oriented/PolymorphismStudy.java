/*
    Author:zhuzhiqiang
    Time:2021/7/14
    多态 demo
 */

abstract class AnimalTest{
    abstract void eat();
}

class CatTest extends AnimalTest{
    public void eat(){
        System.out.println("eat fish");
    }

    public void work(){
        System.out.println("catch mouse");
    }
}

class DogTest extends AnimalTest{
    public void eat(){
        System.out.println("吃骨头");
    }

    public void work(){
        System.out.println("看家");
    }
}
public class PolymorphismStudy {
    public static void main(String[] args){
        show(new CatTest());
        show(new DogTest());

        AnimalTest a = new CatTest();
        a.eat();
        CatTest c = (CatTest) a;
        c.work();
    }

    public static void show(AnimalTest a){
        a.eat();
        if(a instanceof CatTest){
            CatTest c = (CatTest) a;
            c.work();
        }
        else if(a instanceof DogTest){
            DogTest d = (DogTest) a;
            d.work();
        }
    }
}
