/*
    Author:zhuzhiqiang
    Time:2021/7/14
    异常 demo
 */

public class BanckDemo {
    public static void main(String[] args){
        ErrorCheckAccount checkAccount = new ErrorCheckAccount(101);
        System.out.println("D 500");
        checkAccount.deposit(500.00);
        try{
            System.out.println("\nW 100");
            checkAccount.withdraw(100.00);
            System.out.println("\nW 600");
            checkAccount.withdraw(600.00);
        } catch (ErrorStudy errorStudy) {
            System.out.println("Sorry" + errorStudy.getAmount());
            errorStudy.printStackTrace();
        }
    }
}
