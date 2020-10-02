import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/17 10:16
 * @description：
 */

public class test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] arr=str.split(",");
        String[] arrstart=arr[0].split("\\{");
        String start=arrstart[1];
        String[] arrend=arr[arr.length-1].split("}");
        String end=arrend[0];

        int[] array=new int[arr.length];
        array[0]=Integer.valueOf(start);
        array[arr.length-1]=Integer.valueOf(end);
        for (int i = 0; i < arr.length-1; i++) {
            array[i+1]=Integer.valueOf(arr[i]);
        }

        if (array.length<=0 || array==null){
                return;
        }

        int min;


        //StringBuffer sb=new StringBuffer();
        //sb.append(arrstart[1]);
        //StringiBuffer sb=sb.append(arrstart[i]);

        for (int i = 0; i <array.length-1 ; i++) {
            //StringBuffer sbnow=new StringBuffer();

            for (int j = i+1; j < array.length-1; j++) {
                int num1=Integer.valueOf(array[i]+""+array[j]);
                int num2=Integer.valueOf(array[j]+""+array[i]);
                min= Math.min(num1,num2);
            }
        }



        //System.out.println(min);
    }
}
