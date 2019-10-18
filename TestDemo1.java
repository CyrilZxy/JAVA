import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-10-17
 * Time: 21:12
 */
public class TestDemo1 {

    public static void func(int[] array2) {
        array2[0] = 99;
    }
    public static void func2(int x) {
        x = 99;
    }


    public static void main(String[] args) {
        int[] array2 = {1,2,3,4};
        /*for (int i = 0; i < array2.length; i++) {
            System.out.print (array2[i] + " ");
        }*/
       /* for (int x : array2) {
            System.out.print (x + " ");
        }*/
       //Arrays:是java当中操作数组的工具类
        //将数组以字符串的形式进行打印
        System.out.println(Arrays.toString(array2));
        System.out.println();
        func(array2);
      /*  for (int i = 0; i < array2.length; i++) {
            System.out.print (array2[i] + " ");
        }*/
       /* for (int x : array2) {
            System.out.print (x + " ");
        }*/
        System.out.println(Arrays.toString(array2));
        System.out.println();

       /* int a = 10;
        System.out.println(a);
        func2(a);
        System.out.println(a);*/
    }

    public static void main1(String[] args) {
        int[] array = new int[]{1,2,3,4};

        int[] array3 = new int[10];//定义数组
        int[] array2 = {1,2,3,4};
        System.out.println(array2[0]);//1
        System.out.println(array2.length);//4

        for (int i = 0; i < array2.length; i++) {
            System.out.print (array2[i] + " ");
        }
        System.out.println();
        System.out.println(array2);

    }
}
