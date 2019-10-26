

public class demo1026 {
    public static void main(String[] args) {
        Person person1=new Person();
        person1.eat();
        person1.show();
        /*Person person2=new Person();
        Person person3=new Person();
        Person person4=new Person();*/
    }


}
class Person{
    public String name;
    public int age=10;
    public static int count=100;
    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
    public void show(){
        System.out.println("name="+name+"  "+"age="+age);
    }
}