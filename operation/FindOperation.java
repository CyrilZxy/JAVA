package com.operation;

import com.book.Book;

import com.book.BookList;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;
////////////////////////////


public class FindOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("Find-Operation  查找图书:");

        System.out.println("输入查找书名");
        String name=scanner.next();

        int i=0;
        Book book= null;
        for ( ;i<bookList.getUsedSize();i++){
            book = bookList.getBook(i);
            if(book.getName().equals(name)){
                break;
            }
        }

        if (i==bookList.getUsedSize()){
            System.out.println("没有此书");
            return;
        }

        book=bookList.getBook(i);
        System.out.println(book);
        System.out.println("找到此书");


    }
}
