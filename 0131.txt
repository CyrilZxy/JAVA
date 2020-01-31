import java.util.Scanner;


class Calculator {
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add() {
        return this.num1+this.num2;
    }
    public int sub() {
        return this.num1-this.num2;
    }
    public int mul() {
        return this.num1*this.num2;
    }
    public int div() {
        return this.num1/this.num2;
    }
}
class MyValue {
    public int val;
}
public class HomeWork {
    public static void swap2(MyValue a,MyValue b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
    public static void main(String[] args) {
        MyValue myValue1 = new MyValue();
        myValue1.val = 10;
        MyValue myValue2 = new MyValue();
        myValue2.val = 20;
        System.out.println(myValue1.val+" " + myValue2.val);
        swap2(myValue1,myValue2);
        System.out.println(myValue1.val+" " + myValue2.val);
    }

    public static void swap(int a,int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println(num1+" " + num2);
        swap(num1,num2);
        System.out.println(num1+" " + num2);
    }


    public static void main1(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        System.out.println(calculator.add());
        System.out.println(calculator.sub());
        System.out.println(calculator.mul());
        System.out.println(calculator.div());
    }
}
