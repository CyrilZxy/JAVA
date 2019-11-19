package com.bit.demo1;

public class Animal {
    protected String name;
//protected  只要继承就能用  public
    static {
        System.out.println("Animal::static{ }");
    }

    {
        System.out.println("Animal::instance{ }");
    }


    public Animal(String name){
        this.name=name;
        System.out.println("Animal::(String)");
    }
    public void eat(){
        System.out.println(this.name+"eat() !!!");
    }


}
