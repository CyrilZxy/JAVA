package com.bit.ANIMAL;

        import com.bit.ANIMAL.Cat;

public class Test {

    public static void function(Animal animal1){

    }

    public static Animal function2( ){
        Cat cat2=new Cat("小花","红");
        return cat2;
    }
    public static void main(String[] args) {
        Cat cat1=new Cat("小花","红");
        function(cat1);
    }



    public static void main2(String[] args) {
        Cat cat1=new Cat("小花","红");
        Animal animal1=cat1;    //向上转型
        //父类引用 子类的对象
        //animal1.func();     不能访问
        function2().eat();
    }


    public static void main1(String[] args) {
       Cat cat1=new Cat("小花","红");
       /* Cat cat2 =new Cat("小花","红");
        cat1.eat();*/

        Bird brid1=new Bird("小明","羽毛");
/*        brid1.eat();
        brid1.fly();*/
    }


}
