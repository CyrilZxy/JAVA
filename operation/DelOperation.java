package com.operation;

import com.book.Book;
import com.book.BookList;

public class DelOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("Del-Operation   删除图书");

        System.out.println("请输入要删除的图书名：");
        String name=scanner.next();

        int i=0;
        Book book=null;
        for (; i<bookList.getUsedSize() ; i++) {
            book=bookList.getBook(i);
            if (book.getName().equals(name)){
                break;
            }
        }

        if (i==bookList.getUsedSize()){
            System.out.println("没有此书");
            return;
        }

        //找到此书时,在bookList中删除。  后面book依次前移，getusedsize-1
        book=bookList.getBook(i);
        for (int j = i; j <bookList.getUsedSize()-1 ; j++) {
            book=bookList.getBook(j+1);
            bookList.setBooks(j,book);
        }
        int curSize = bookList.getUsedSize();
        bookList.setUsedSize(curSize-1);
        System.out.println("删除成功！");


    }
}
