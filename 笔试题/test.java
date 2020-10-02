import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/7 15:12
 * @description：
 */

public class test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=Integer.valueOf(sc.nextLine());
        String str=sc.nextLine();
        String[] arr=str.split("");
        menthod(k,arr);

    }
    public static void menthod(int k,String[] arr){

        for(int i=0;i<arr.length;i++){
            int a=Integer.valueOf(arr[i]);
            if(a>=k){
                return;
            }else{
                for (int j = i; j <arr.length; j++) {
                    int b=Integer.valueOf(arr[j]);
                    if(a+b==k){
                        System.out.println(a+" "+b);
                    }
                }
            }

        }
    }


}
