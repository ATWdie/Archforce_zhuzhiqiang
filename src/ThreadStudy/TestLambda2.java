package ThreadStudy;

/*
总结：
1、Lambda表达式只能有一行代码的情况下才能简化为一行，如果有多行就用代码块包裹。
2、前提是接口为函数式接口
3、多个参数可以去掉参数类型，要去掉就都去掉，必须加上括号。
 */
public class TestLambda2 {

    public static void main(String[] args) {
        ILove love = null;
/*
        ILove love = (int a) -> {
            System.out.println("i love " + a);
        };

        //简化1:参数类型
        love = (a) -> {
            System.out.println("i love " + a);
        };

        //简化2:括号
        love = a -> {
            System.out.println("i love " + a);
        };*/

        //简化3:去掉花括号
        love = a -> System.out.println("i love " + a);

        love.love(15);
    }
}

interface ILove{
    void love(int a);
}
