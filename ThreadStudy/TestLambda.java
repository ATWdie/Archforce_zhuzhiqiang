package ThreadStudy;

/*
推导lambda表达式
 */
public class TestLambda {

    //静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        like = new Like3();
        like.lambda();
    }
}

//定义一个函数式接口
interface ILike{
    void lambda();
}

class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
