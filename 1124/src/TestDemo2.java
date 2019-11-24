
class Money implements Cloneable{
    double money=12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


class Person implements Cloneable{
    public String name;
    public Money m;

    public Person( ) {  //alt+inster
        this.m = new Money();

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Person per=(Person)super.clone();
        per.m=(Money)this.m.clone();

        return per;
        //return super.clone();
    }
}


public class TestDemo2 {
                                            //main 函数声明 throws CloneNotSupportedException
    public static void main(String[] args)  throws CloneNotSupportedException{
        Person person1 = new Person();
        person1.name = "caocao";

        Person person2 = (Person) person1.clone();

        System.out.println(person1.m.money +" "+ person1.name);
        System.out.println(person2.m.money +" "+ person2.name);

        System.out.println("-----------------------");
        person2.m.money = 66.66;
        person2.name = "zhangfei";

        System.out.println(person1.m.money +" "+ person1.name);
        System.out.println(person2.m.money +" "+ person2.name);

    }

}
