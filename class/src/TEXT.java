

public class TEXT {

    /*public static void main1(String[] args) {
        Person person1=new Person();          //new
        System.out.println(person1.name);
        System.out.println(person1.age);
        person1.eat();                    //使用.访问对象中的方法
        person1.sleep();
        person1.age=10;
        System.out.println(person1.age);  //使用.访问对象中的属性
        Person person2=new Person();
        Person person3=new Person();
    }
    public static void main2(String[] args) {
        Person person1=new Person();
        System.out.println("我叫"+person1.name+",今年"+person1.age+"岁。");
        person1.show();
        Person person2=new Person();
        person2.name="李四";
        person2.age=20;
        person2.show();
        System.out.println(person2.name.length());          //获取字符串长度
    }

    public static void main3(String[] args) {
        TestDemo t1=new TestDemo();
        t1.a++;
        TestDemo.count++;
        System.out.println(t1.a);
        System.out.println(TestDemo.count);
        System.out.println("=============");
        TestDemo t2=new TestDemo();
        t2.a++;
        TestDemo.count++;
        System.out.println(t2.a);
        System.out.println(TestDemo.count);
    }

    public static void main4(String[] args) {
        TestDemo.change();;
        System.out.println(TestDemo.count);
    }

    public static void main4(String[] args) {
        Person person1=new Person();
        person1.setName("caocao");
        String name=person1.getName();
        System.out.println(name);
        person1.show();

    }
 */

        public static void main(String[] args) {
            //Person person1=new Person();
            new Person("caocao",19).show();//通过匿名对象调用方法
            //Person p1 = new Person("caocao",19);
            // p1.show();
            //System.out.println(p1);

            //Person p2 = new Person();
            //p1.show();
            //Person person2=new Person("zhangfei",20,"男");
            // person2.show();
        }



}
