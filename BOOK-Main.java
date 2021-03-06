package com;

import com.book.BookList;
import com.user.Admin;
import com.user.NormalUser;
import com.user.User;

import java.util.Scanner;

public class Main {

    public static User login(){
        Scanner scanner=new Scanner(System.in);

        System.out.println("输入姓名：");
        String name = scanner.nextLine();

        //Scanner scanner2=new Scanner(System.in);
        System.out.println("请输入你的身份：1-》管理员 0：普通用户");
        int who = scanner.nextInt();

        if(who == 1) {
            return new Admin(name);
        }else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {

        //准备书籍
        BookList bookList=new BookList();

        //登录  返回对象  1.Admin   0.NormalUser
        User user =  login();                      //user=所选择的登入对象

        while(true) {

            //记录choice 在不同menu中
            int choice = user.menu();

            //如何去对应操作  Admin，NormalUser  继承user中
            user.doOperation(choice, bookList);
        }

    }
}
