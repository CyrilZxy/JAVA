
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/20 15:25
 * @description：
 */

//数组组成最大数
public class dada {
    //22,3,450
    //543220

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] arr=str.split(",");


        StringBuffer sb=new StringBuffer();
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length() ; j++) {
                sb.append(arr[i].charAt(j));
            }
        }
        String str0=sb.toString();      //223450
        //System.out.println(str0);
        String[] arr0=str0.split("");



        StrSort(arr0);       //排序比较组合最大
        //System.out.println(Arrays.toString(arr));       //拿到排序最大的数组

        //进行输出
        String s="";
        for (int i = 0; i <arr0.length ; i++) {
            s=s+arr0[i];
        }
        System.out.println(s);

    }

    public static void StrSort(String[] arr){
        Arrays.sort(arr,new StrCompare());
    }

}
class  StrCompare implements Comparator<String> {
    @Override
    public int compare(String o1,String o2) {
        return(o2+o1).compareTo(o1+o2);
    }
}