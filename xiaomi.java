import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/15 19:24
 * @description：
 */

public class xiaomi {
    //输入：
    //A,B,C,E
    //S,F,C,S
    //A,D,E,E
    //
    //输出：
    //true
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        HashMap<String,Integer> map=new HashMap<>();

        boolean flag=true;
        String end=new String();            //标志最后一行

        //录入第一行到倒数第二行
        while (flag){
            String str=sc.nextLine();
            if (!str.contains(",")){
                flag=false;
                end=str;        //录入倒数第一行
                break;
            }
            String[] arr=str.split(",");
            for (int j = 0; j <arr.length ; j++) {
                String m=arr[j];
                if(map.containsKey(m)){
                    map.put(m,map.get(m)+1);
                }else{
                    map.put(m,1);
                }
            }
        }

        //传参查找
        System.out.println(menth(end,map));

    }

    public static boolean menth(String end,HashMap<String,Integer> map){
        if(end==null || end.length()==0){
            return false;
        }
        String[] array=end.split("");

        for (int i = 0; i <array.length ; i++) {
            String e=array[i];
            if(!map.containsKey(e)){
                return false;
            }
            if(map.get(e)<=0){
                return false;
            }
            else {
                map.put(e,map.get(e)-1);
            }
        }
        return true;
    }





    //分解质因数
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;

        int _num;
        _num = Integer.parseInt(in.nextLine().trim());

        res = primeFactorization(_num);

        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }
    }
    public static int[] primeFactorization(int num) {

        List<Integer> list=new ArrayList<>();

        boolean isprime=true;
        if(num%2==0){
            isprime=false;
        }
        if(isprime){
            for (int i = 0; i <=Math.sqrt(num) ; i+=2) {
                if(num%i==0){
                    isprime=false;
                    break;
                }
            }
        }

        if(isprime){
            //System.out.println("为质数");
        }
        //不为质数，开始分解
        else {
            boolean isprime2;
            for (int i = 2; i <=num ; i++) {
                isprime2=true;
                for (int j = 2; j <Math.sqrt(i) ; j++) {
                    if(i%j==0){
                        isprime2=false;
                        break;
                    }
                }
                if (num%i==0) {
                    num/=i;
                    list.add(i);
                    //System.out.println(i);
                    i--;
                }
            }
        }

        int[] arr=new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            arr[i]=list.get(i);
        }
        //System.out.println(list);
        //System.out.println(arr);
        return arr;
    }
}
