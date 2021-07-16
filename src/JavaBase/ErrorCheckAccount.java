package JavaBase;

/*
    Author:zhuzhiqiang
    Time:2021/7/14
    异常 demo
 */

public class ErrorCheckAccount {
    private double balance;
    private int number;
    public ErrorCheckAccount(int number){
        this.number = number;
    }

    //方法:存钱
    public void deposit(double amount){
        balance += amount;
    }

    //方法:取钱
    public void withdraw(double amount) throws ErrorStudy{
        if(amount <= balance){
            balance -= amount;
        }
        else{
            double needs = amount - balance;
            throw new ErrorStudy(needs);
        }
    }
    //返回余额
    public double getBalance(){
        return balance;
    }
    public int getNumber(){
        return number;
    }
}
