package com.bit;

public class Demo2 {
    public static void main(String[] args) {
		//如果某个成员不包含 public    private    protected 关键字, 
		//此时这个成员可以在包内部的其他类使用, 但是不能在包外部的类使用.

		//包访问权限（default 默认）：只能访问同一个包中的内容
        Demo1 demoeg=new Demo1();
        System.out.println(demoeg.value);
    }
}
