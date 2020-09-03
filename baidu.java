import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/3 19:46
 * @description：
 */

public class baidu {
    //输入：      0 0
    //      LLRR
    //0 0
    //四个字符U、D、L和R，分别表示上、下、左、右
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        menthod(str1,str2);
    }
    public static void menthod(String str1,String str2){
        String[] arr1=str1.split(" ");
        int x=Integer.valueOf(arr1[0]);
        int y=Integer.valueOf(arr1[1]);
        String[] arr2=str2.split("");

        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i].equals("R")){
                x++;
            }
            if(arr2[i].equals("L")){
                x--;
            }
            if(arr2[i].equals("U")){
                y++;
            }
            if(arr2[i].equals("D")){
                y--;
            }


        }

        System.out.println(x+" "+y);
    }

}
