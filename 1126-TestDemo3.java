package com.zxy;
//抽象类

abstract class Shape2 {
    /* public int a;
     public void func() {
         System.out.println("func()");
     } */
    public abstract void draw();//抽象方法
}

abstract class Rect2 extends Shape2 {
//    @Override
//    public void draw() {
//        System.out.println("♦");
//    }
    //public abstract void func();
}

class Rect3 extends Rect2 {
    @Override
    public void draw() {
        System.out.println("♦");
    }
}
class Cycle2 extends Shape2{
    @Override
    public void draw() {
        System.out.println("○");
    }
}
class Flower2 extends Shape2{
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
class Triangle2 extends Shape2 {
    @Override
    public void draw() {
        System.out.println("△");
    }
}
public class TestDemo3 {
    public static void drawMap (Shape2 shape2) {
        shape2.draw();
    }
    public static void main(String[] args) {
        //提前检查代码的错误
        //Shape2 shape2 = new Shape2();

        //Rect2 rect2 = new Rect2();
        Cycle2 cycle2 = new Cycle2();
        Flower2 flower2 = new Flower2();
        //drawMap(rect2);
        drawMap(cycle2);
        drawMap(flower2);
    }
}
