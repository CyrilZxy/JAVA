
class Person {
    private String name;//null
    private int age;//0

    public static int count = 66666666;
    public final int SIZE = 88;
    public static final int SIZE2 = 99;

    //静态代码块  -》 初始化静态的数据成员
    static {
        count = 88888888;
        System.out.println("静态代码块");
    }
    //实例代码块--》初始化实例数据成员
    {
        this.age = 10000;
        this.name = "哪吒";
        //count = 9999;
        System.out.println("实例代码块");
    }


    //构造方法
    public Person() {
        //this.name = "王母娘娘";
        //this("sunwukong");
        //this("sunwukong2",8888);
        System.out.println("Person()");
    }


    public Person(String name) {
        this.name = name;
        System.out.println("Person(String)");
    }
    public Person(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person(String,int)");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void eat(){
        System.out.println("吃饭");
    }
    public void sleep() {
        this.eat();
        System.out.println("睡觉");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void func1() {
        //System.out.println("name : " + this.name);error
        count = 999;
        System.out.println("static.func1()");
    }
}

public class TestDemo {

    public static void func(Person person) {
        System.out.println(person.getName());
        person.sleep();
    }

    public static int[] func2(int[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i]*2;
        }
        return array;
    }

    public static void main(String[] args) {

    }


    public static void main6(String[] args) {
        Person person1 = new Person();
        System.out.println("=============");
        Person person2 = new Person();
        System.out.println("=============");
        Person person3 = new Person();
    }

    public static void main5(String[] args) {
        Person person1 = new Person();
        System.out.println(person1);
        /*System.out.println(person1.getName());//
        System.out.println(person1.getAge());//
        System.out.println(Person.count);*/
    }


    public static void main4(String[] args) {
        Person person1 = new Person();
        System.out.println("===============");
        Person person2 = new Person("caocao");
        System.out.println("===============");
        Person person3 = new Person("caocao",99);
    }


    public static void main3(String[] args) {
        Person person = new Person();
        person.setName("caocao");
        person.setAge(88);
        System.out.println(person.getName());//caocao
        System.out.println(person.getAge());
        Person person2 = new Person();
        person2.setName("zhangfei");
        person2.setAge(188);
        System.out.println(person2.getName());//zhangfei
        System.out.println(person2.getAge());
        //person.name = "caocao";
        /*person.age = 99;*/

    }


    public static int sum(int a,int b) {
        return a+b;
    }

    public static void main2(String[] args) {

        //System.out.println(sum(1,2));

        /*Person person1 = new Person();
        Person.func1(person1);*/

        /*Person person1 = new Person();
        person1.eat();*/

        //System.out.println(person1.name.length());
    }

    public static void main1(String[] args) {
        //实例化一个对象   new
//        Person person1 = new Person();
//        Person.count++;
//        System.out.println(Person.count);
//        //Person person2 = new Person();
//        Person.count++;
//        System.out.println(Person.count);


        //person1.show();
        //Person person2 = new Person();
        /*Person person3 = new Person();
        Person person4 = new Person();*/

    }
}
