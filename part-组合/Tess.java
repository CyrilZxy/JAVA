package com.bit.part;

class Student{
    public String name;
    public Address address;

    public Student(String name,Address address){
        this.name=name;
        this.address=address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
class Address{
    private String house;
    private int floor;

    public Address(String house,int floor){
        this.house=house;
        this.floor=floor;

    }


    @Override
    public String toString() {
        return "Address{" +
                "house='" + house + '\'' +
                ", floor=" + floor +
                '}';
    }
}



public class Tess {
    public static void main(String[] args) {
        Address address1=new Address("6号楼",3);
        Student student1=new Student("zxy",address1);
        System.out.println(student1);
    }
}
