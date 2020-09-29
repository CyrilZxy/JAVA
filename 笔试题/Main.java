public class Main{
    public static void main(String[] args) {

        int a=new Integer(123);
        int b=new Integer(123);
        int c=123;
        int d=Integer.valueOf(123);

        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(c==d);
/*        Integer  a=new Interger(123);
        Integer  b-new Integer(123);
        Integer  c=123;
        Integer  d=Integer.valueOf(123);*/
    }
}