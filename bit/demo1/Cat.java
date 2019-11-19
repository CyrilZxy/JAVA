package com.bit.demo1;

//  继承 ：代码复用！！

//           子类   继承   父类    子类需帮助父类来构造。
public class Cat extends Animal{        //继承了animal    is a 是一个animal
                                         //继承 除构造函数外的所有!!
    //public String name;  可省略 父类中有
    public String color;        //子类独有的数据

    static {
        System.out.println("Cat::static{ }");
    }

    {
        System.out.println("Cat::instance{ }");
    }

    public Cat(String name,String color){           //继承后
        super(name);        //显示调用父类的构造方法--帮助父类进行构造
                            //super 必须是第一行。子类构造时，需先构造父类。
        //this.name=name;   super（）使用后，可省略不写。
        this.color=color;
        System.out.println("Cat(String,String)");
    }
//    public void eat(){
//        System.out.println(this.name+"eat()");
//    }
}
