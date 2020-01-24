package com.bit.ANIMAL;

public class Test2 {
    public static void main(String[] args) {
        Animal animal1=new Bird("小草1","红");
        animal1.eat();
        //animal1.fly();  不可使用。

        if (animal1 instanceof Bird) {
            Bird bird = (Bird)animal1;
            bird.fly();
        }


/*        Bird bird1=(Bird)animal1;  //new一个brid1 强转animal1为brid1
        bird1.fly();                    //此时可调用fly*/
        //((Bird) animal1).fly();         //

    }

}
