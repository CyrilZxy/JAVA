package com;
import java.util .*;         //导入java.util下所有包

class Person{
    int age;
}


public class TestDemo {

/*   合并
import java.util.Arrays;     //导入java.util.Arrays包
import java.util.Date;       //导入java.util.Date包
*/


//import java.sql.*;        也有Date，会冲突。建议一个一个导入。

    /**
     * java.utill   工具类
     * java.long  包下的所有，不用导入。编译器自动导入。
     */


    public static void main(String[] args) {

        int[] array1 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(array1));


        //格林威治时间 1970.1.1
        java.util.Date date1 = new java.util.Date();      //无需导入包
        System.out.println(date1.getTime());

        Date date2 = new java.util.Date();            //需导入包
        System.out.println(date2.getTime());


        //System.out.println("java zzz");
    }
}



