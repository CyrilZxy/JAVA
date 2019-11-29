package com.user;

import com.book.BookList;
import com.operation.IOperation;

import java.awt.*;

public abstract class User {
    public String name;
    public IOperation[] operations;     //接口数组     普通用户，管理员接口数组不同。



    //返回操作选择 choice，对booklist进行操作
    public void doOperation(int choice,BookList bookList){
        operations[choice].work(bookList);

        //选择choice对应接口数组中第几个下标数组 ，  即对应接口下的操作类
        //然后 . 接口的work方法，work方法被类重写。

    }


    public abstract int menu();
}
