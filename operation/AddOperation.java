package com.operation;

import com.book.Book;
import com.book.BookList;

public class AddOperation implements IOperation{        // 类实现接口，重写接口方法


    @Override
    public void work(BookList bookList) {
        System.out.println("Add-Operation   新增图书");

        System.out.println("请输入图书名字：");
        String name=scanner.next();
        System.out.println("请输入图书作者：");
        String author=scanner.next();
        System.out.println("请输入图书价格：");
        int price=scanner.nextInt();
        System.out.println("请输入图书类型：");
        String type=scanner.next();

        Book newbook=new Book(name,author,price,type);  //new一个书，将所有录入的属性附上
        int pos=bookList.getUsedSize();         //找到插入位置
        bookList.setBooks(pos,newbook);         //插入新书

        bookList.setUsedSize(pos+1);        //书数组 所用了的空间+1




    }




}
