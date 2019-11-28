package com.book;

public class Book {
    private String name;
    private String author;
    private int price;
    private String type;
    private boolean isBorrwed;

    public Book(String name, String author, int price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
        //this.isBorrwed = isBorrwed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBorrwed() {
        return isBorrwed;
    }

    public void setBorrwed(boolean borrwed) {
        isBorrwed = borrwed;
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", aunthor='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", "+
                (isBorrwed==true?"已借出":"未借出")
                +"}";

    }
}
