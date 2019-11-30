package com.operation;

import com.book.Book;
import com.book.BookList;

import java.util.Scanner;

public class BorrowOperation  implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("Borrow-Operation    借阅图书");

        System.out.println("请输入借阅书籍书名:");
        String name=scanner.next();

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

        //找到此书时
        book=bookList.getBook(i);
        if(book.isBorrwed()){       //判断是否被借出
            System.out.println("此书被借出");
        }else{
            book.setBorrwed(true);
            System.out.println("借阅成功");
        }




    }
}
