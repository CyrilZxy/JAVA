import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/8/29 20:05
 * @description：    科大
 */

public class keda {

    public static void main(String[] args) {
        //6  3*3=9
        //7  3*4=12
        Scanner sc=new Scanner(System.in);
        int l=sc.nextInt();
        System.out.println(cut(l));

    }

    public static int  cut(int l) {
        //分段大于1段
        if(l==2 ){
            return 1;
        }
        if(l==3){
            return 2;
        }

        int out=1;

        while(l>4){
            l=l-3;
            out=out*3;
        }

        return l*out;
    }


 /*   public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int length=Integer.valueOf(sc.nextLine());
        String str=sc.nextLine();
        int key=Integer.valueOf(sc.nextLine());

        String[] arr=str.split(" ");
        System.out.println(binarySearch(arr,key,0,length));
    }


    public static int binarySearch(String[] array,int key,int left,int right) {
        if(left > right) {
            return -1;
        }
        int mid = (left+right)>>1;
        if(Integer.valueOf(array[mid]) == key) {
            return mid;
        }else if(Integer.valueOf(array[mid]) > key) {
            return binarySearch(array, key, left, mid - 1);
        }else {
            return binarySearch(array,key,mid+1,right);
        }

    }*/
}
