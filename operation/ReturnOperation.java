package com.operation;

import com.book.Book;
import com.book.BookList;

public class ReturnOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("Return-Operation    归还图书");

        System.out.println("输入要归还的图书名称：");
        String name=scanner.next();


        //1.查找图书是否存在
        //先查找是否拥有这本书
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

        //2.找到此书时,判断是否被借阅
        book=bookList.getBook(i);
        if(book.isBorrwed()){       //判断是否被借出
            book.setBorrwed(false);
            System.out.println("归还成功");
        }else{
            System.out.println("该书没有被借阅");
        }


    }
}
