/*
    Author:zhuzhiqiang
    Time:2021/7/14
    虚函数 demo
 */

class Employee{
    private String name;
    private String address;
    private int number;
    public Employee(String name, String address, int number){
        System.out.println("Employee 构造函数");
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public void mailCheck(){
        System.out.println("邮票邮寄给: " + this.name + " " + this.address);
    }
    public String toString(){
        return name + " " + address + " " + number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumber() {
        return number;
    }

    public void setAddress(String newAddress){
        address = newAddress;
    }
}

class Salary extends Employee{
    private double salary;
    public Salary(String name, String address, int number, double salary){
        super(name, address, number);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void mailCheck(){
        System.out.println("Salary mailCheck");
        System.out.println("邮寄支票给：" + getName() + " " + getSalary());
    }

    public double computePay(){
        System.out.println("计算工资,付给: " + getName());
        return salary/52;
    }
}
public class VirtulStudy{
    public static void main(String[] args){
        Salary s = new Salary("员工A","北京", 3, 3600.00);
        Employee e =new Salary("员工B", "上海", 2, 2400.00);
        System.out.println("使用Salary的引用调用mailCkeck--");
        s.mailCheck();
        System.out.println("\n使用Employee的引用调用mailCkeck--");
        e.mailCheck();
    }
}
