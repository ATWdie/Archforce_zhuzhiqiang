import java.io.*;

/*
    Author:zhuzhiqiang
    Time:2021/7/14
    异常 demo
 */

public class ErrorStudy extends Exception{
    //此处的amount用来储存当出现异常（取出钱多于余额时）所缺乏的钱
    private double amount;
    public ErrorStudy(double amount){
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }
}
