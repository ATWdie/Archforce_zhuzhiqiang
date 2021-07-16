/*
    Author:zhuzhiqiang
    Time:2021/7/14
    抽象类 demo
 */

abstract class EmployeeA{
    private String name;
    private String address;
    private int number;

    public EmployeeA(String name, String address, int number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public double computePay(){
        System.out.println("Inside Employee computePay");
        return 0.0;
    }

    public void mailCheck(){
        System.out.println("Mailing a check to " + this.name + " " + address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "EmployeeA{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number=" + number +
                '}';
    }
}

class SalaryA extends EmployeeA{
    private double salary;

    public SalaryA(String name, String address, int number, double salary) {
        super(name, address, number);
        this.salary = salary;
    }

    public void mailCheck(){
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName() + "with salary" + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary){
        if(newSalary >= 0.0){
            this.salary = newSalary;
        }
    }

    public double computePay(){
        System.out.println("computing salary pay for " + getName());
        return salary/2;
    }
}
public class AbstractStudy {
    public static void main(String[] args){
        SalaryA s = new SalaryA("name", "address", 1, 3600.00);
        EmployeeA e = new SalaryA("name1", "address1", 2, 2400.00);

        s.mailCheck();
        e.mailCheck();
    }
}
