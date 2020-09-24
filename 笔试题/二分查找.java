import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/8/26 15:55
 * @description：    二分查找
 */

public class 二分查找 {

    public static void main(String[] args) {

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

    }


}
