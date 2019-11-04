

/*
class <class_name>{
        field;//成员属性
        mothod;//成员方法
        }

//实例化对象
<class_name> <对象名>=new <class_name>();
*/

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
/*
class Person1 {
    public String name="张欣悦";         //字段
    public int age=19;


    public String sex;
    public void eat(){                   //  函数=成员方法
        System.out.println("吃饭！");
    }
    public void sleep(){
        System.out.println("睡觉！");
    }

}

class Person2 {
    private String name="张欣悦";
    private int age = 19;

    public void setName(String name){
        // name=name;
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void show(){
        System.out.println("name:"+name+" age:"+age);
    }
    public void show2() {
        System.out.println("我叫" + name + ",今年" + age + "岁。");
    }
}

class Person3 {
    private String name;
    private int age;
    private String sex;

    public Person(){
        this("zxy",19,"woman");
        //this.name="zxy";
        //this.age=18;
        //this.sex="女";
    }
    public Person(String name,int age,String sex){
        this.name=name;
        this.age=age;
        this.sex=sex;
    }
    public void show(){
        System.out.println("name:"+name+" age:"+age);
    }

}
*/
class Person{
    private String name;//实例成员变量
    private int age;
    private String sex;
    private static int count = 0;//静态成员变量 由类共享数据 方法区
    public Person(String name,int age) {
        this.age = age;
        this.name = name;
    }
    public void show(){
        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
    }
    //重写Object的toString方法

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /*public Person() {
        System.out.println("I am Person init()!");
    }*/


    //实例代码块
    {
        this.name = "bit";
        this.age = 12;
        this.sex = "man";
        System.out.println("I am instance init()!");
    }

    //静态代码块
    static {
        count = 10;//只能访问静态数据成员
        System.out.println("I am static init()!");
    }


}




