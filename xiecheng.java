import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/8 19:40
 * @description：
 */

public class xiecheng {
    //1 2 3 4   能力
    //1 1       系数
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();      //录入
        String str2=sc.nextLine();

        menthod(str1,str2);     //方法
    }

    public static void menthod(String str1,String str2){
        int[] array1=change(str1);      //处理数据得到int数组
        int[] array2=change(str2);

        HashMap<Integer,Integer> map=new HashMap<>();       //系数，任务数
        for (int i = 0; i <array2.length ; i++) {
            if(map.containsKey(array2[i])){
                map.put(array2[i],map.get(array2[i])+1);
            }else{
                map.put(array2[i],1);
            }
        }

        int out=0;
        for (int i = 0; i <array1.length ; i++) {

            int k=array1[i];
            //系数大于能力    array2>array1 y>=x

            for(int j=0;j<array2.length;j++){
                if(array2[j]>=k){
                    if(map.containsKey(array2[j])){
                        if (map.get(array2[j])>0){
                            out=out+1;
                            map.put(array2[j],map.get(array2[j])-1);
                            break;
                        }else{
                            map.remove(array2[j]);
                        }
                    }
                }
            }



        }
        System.out.println(out);
    }

    public static int[] change(String str){
        String[] arr=str.split(" ");
        int len=arr.length;
        int[] array=new int[len];
        for(int i=0;i<len;i++){
            array[i]=Integer.valueOf(arr[i]);
        }
        return array;
    }
}
/*
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();      //录入
        String str2=sc.nextLine();

        menthod(str1,str2);     //方法
    }

    public static void menthod(String str1,String str2){

        if(str1==null || str2==null){
            return;
        }
        int[] array1=change(str1);      //处理数据得到int数组
        int[] array2=change(str2);

        HashSet<Integer> set=new HashSet<>();

        for (int i = 0; i <array2.length ; i++) {
            set.add(array2[i]);
        }

        int out=0;
        for (int i = 0; i <array1.length ; i++) {
            if(set.contains(array1[i])){
                out=out+1;
            }
        }
        System.out.println(out);
    }

    public static int[] change(String str){
        String[] arr=str.split(" ");
        int len=arr.length;
        int[] array=new int[len];
        for(int i=0;i<len;i++){
            array[i]=Integer.valueOf(arr[i]);
        }
        return array;
    }*/
