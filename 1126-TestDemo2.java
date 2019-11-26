package com.zxy;

//多态

class Shape {
    public void draw(){     //draw 方法被重写

    }
}
class Rect extends Shape {
    @Override  //ctrl+o
    public void draw() {
        System.out.println("♦");
    }
}
class Cycle extends Shape{
    @Override
    public void draw() {
        System.out.println("○");
    }
}
class Flower extends Shape{
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("△");
    }
}
public class TestDemo2 {

    public static void drawMap (Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        /*Rect rect = new Rect();
        Cycle cycle = new Cycle();
        Flower flower = new Flower();
        drawMap(rect);
        drawMap(cycle);
        drawMap(flower);
        */
        Shape shape = new Rect();
        Shape shape2 = new Cycle();
        Shape shape3 = new Flower();
        Shape shape4 = new Triangle();
        drawMap(shape);
        drawMap(shape2);
        drawMap(shape3);
        drawMap(shape4);
    }
}
