import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/13 19:42
 * @description：
 */

public class didi {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] arr0=sc.nextLine().split(" ");
        int n=Integer.valueOf(arr0[0]);
        int m=Integer.valueOf(arr0[1]);

        HashMap<String,Integer> map=new HashMap<>();
        for (int i = 0; i <m ; i++) {
            String[] arr=sc.nextLine().split(" ");
            String s=arr[0]+arr[1];
            map.put(s,Integer.valueOf(arr[2]));
        }
        String[] endline=sc.nextLine().split(" ");
        int s=Integer.valueOf(endline[0]);
        int e=Integer.valueOf(endline[1]);
        String start=endline[2];
        String x=Integer.toString(s)+Integer.toString(e);
        System.out.println(x);
    }

    //3
    //G o   g   o   ,       g   o       o  u   t      !  ?
    //1 2   3   1   2   3   1   2   3   1  2   3      1  2
    //输出
    //goG ,o ogtuo?!
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=Integer.valueOf(sc.nextLine());   //3
        String str=sc.nextLine();               //G o   g   o   ,       g   o       o  u   t      !  ?

        int len=str.length();       //14
        int i=0;
        StringBuffer sb=new StringBuffer();

        while(len>0){
            if(len/x>=1) {
                for (int j = i,z=x-1; z >=0 ; z--) {
                    char n=str.charAt(j+z);
                    sb.append(n);
                }
                /*char n1 = str.charAt(i);
                char n2 = str.charAt(i + 1);
                char n3 = str.charAt(i + 2);
                sb.append(n3);
                sb.append(n2);
                sb.append(n1);*/
                i = i + x;
                len = len - x;
            }else {
                  break;
            }
        }

        for (int j = len-1; j >=0 ; j--) {
            char end=str.charAt(i+j);
            sb.append(end);
        }

        System.out.println(sb);
    }
}
