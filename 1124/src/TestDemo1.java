import java.lang.reflect.Array;
import java.util.Arrays;

class Student implements Comparable<Student>{
    public String name;
    public int age;
    public double score;


    public Student(String name, int age, double score){  //alt+inster
        this.name=name;
        this.age=age;
        this.score=score;
    }


    @Override
    public String toString() {
        return this.name+"+"+this.age+"+"+this.score;
        //return super.toString();
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
        //return (int)(this.score-o.score);
        //return o.age-this.age;
        //return this.age-o.age;

        //return 0;
    }
}



public class TestDemo1 {
    public static void main(String[] args) {
        Student[] students=new Student[3];
        students[0] =new Student("zhangfei",20,76.4);
        students[1] =new Student("caocao",18,92.3);
        students[2] =new Student("guanyu",25,66.88);

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
