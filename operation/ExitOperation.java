package com.operation;

import com.book.BookList;

public class ExitOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("Exit-Operation  退出系统");
        System.exit(1);
    }
}
