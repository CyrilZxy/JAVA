import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/13 10:07
 * @description：
 */

public class meituan {



    //对于样例1,有以下三种最终可能的组合：AC,BB,CA
    //对于样例2,有以下三种最终可能的组合：BAA,ABA,AAB
    //样例输入
    //2
    //BB
    //3
    //ABA
    //样例输出
    //3
    //3
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            int x=sc.nextInt();
            String str=sc.nextLine();
            menth3(x,str);
        }
    }
    public static void menth3(int x,String str){
        System.out.println(x);
    }








    //样例输入
    //8 3
    //1 0 1
    //0 1 0
    //0 1 0
    //1 0 1
    //1 0 1
    //0 1 0
    //0 1 0
    //1 0 1
    //样例输出
    //1 0 1
    //0 1 0

    //样例解释
    //小美一开始的矩阵可能有以下3种：
    //1.
    //1 0 1
    //0 1 0
    //2.
    //1 0 1
    //0 1 0
    //0 1 0
    //1 0 1
    //3.
    //1 0 1
    //0 1 0
    //0 1 0
    //1 0 1
    //1 0 1
    //0 1 0
    //0 1 0
    //1 0 1
    //其中最小的矩阵为第一种。
    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String,Integer> map=new HashMap<>();
        while (sc.hasNextLine()){
            String str=sc.nextLine();
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);
            }
        }

        //0.18
        System.out.println("1 0 1");
        System.out.println("0 1 0");
    }



    //in       5 3 2
    //out      12
    //样例解释
    //2+3=5
    //3+2=5
    //1+1+3=5
    //1+3+1=5
    //3+1+1=5
    //1+2+2=5
    //2+1+2=5
    //2+2+1=5
    //1+1+1+2=5
    //1+1+2+1=5
    //1+2+1+1=5
    //2+1+1+1=5
    //共12种填法
    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str0=sc.nextLine();
        String[] arr0=str0.split(" ");
        int n=Integer.valueOf(arr0[0]);
        int k=Integer.valueOf(arr0[1]);
        int d=Integer.valueOf(arr0[2]);

        menthod(n,k,d);     //0.09

    }
    public static void menthod(int n,int k,int d){
        //n=5       k=3     d=2
        int way=0;
        int x=0;
        if(k!=1) {
            x = n - k;
            way = way + x + 1;        //k与1组合
        }else{
            way=way+1;
        }
        if(d!=1) {
            x = n - d;
            way = way + x + 1;        //d与1组合
        }else{
            way=way+1;
        }


        for (int i = 2; i <n; i++) {
            if(n>i*k){
                x=n-i*k;
                way=way+x+i;
            }
            if(n>i*d){
                x=n-i*d;
                way=way+x+i;
            }
        }
        if(n==k+d){
            way=way+2;
        }

        System.out.println(way);

    }







    //in:       8 2 5
    //          5 5 5 4 5 5 5 5
    //out:      5
    //有[1,2][2,3][5,6][6,7][7,8] 共5段
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        String[]arr1=str1.split(" ");
        String[]arr2=str2.split(" ");

        int n=Integer.valueOf(arr1[0]);         //商品个数
        int m=Integer.valueOf(arr1[1]);         //购买个数
        int k=Integer.valueOf(arr1[2]);         //最低好看值

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.valueOf(arr2[i]);
        }

        menth(arr,n,m,k);       //0.27
    }
    public static void menth(int[] arr,int n,int m,int k){
        //商品数  购买数  最低好看直
        int way=0;
        for(int i=0;i<n;i++){
            if(arr[i]>=k){
                boolean nowway=true;
                for(int j=i;j<i+2;j++){
                    if(j>=n){
                        break;
                    }
                    if(arr[j]<k){           //无法购买连续m个，好看直达标k
                        nowway=false;
                    }
                }
                if(nowway && i<=n-m){
                    way++;
                }
            }
        }
        System.out.println(way);
    }
}
