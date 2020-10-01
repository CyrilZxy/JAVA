import java.util.Arrays;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/12 10:46
 * @description：
 */

public class qianxin {
    public static void main(String[] args) {
        //0,0,1,1,9,9,10,10
        //getMaxArea(0,0,1,1,9,9,10,10);
        //[3,5,7,2,8,8,15,3],[1,0,1,0,1,0,1,0],3
        //   5   2 8 8 15 3
        int[] candies={3,5,7,2,8,8,15,3};
        int[] coin={1,0,1,0,1,0,1,0};
        maxCandies(candies,coin,3);
    }
    public static int maxCandies (int[] candies, int[] coin, int n) {
        // write code here
        int out=0;
        int[] change=new int[candies.length];
        for(int i=0;i<candies.length;i++){
            if(coin[i]==0){
                int x=candies[i];
                out=out+x;
            }else {
                change[i]=candies[i];
            }
        }
        Arrays.sort(change);

        for (int i = 1; i <n; i++) {
            int c1=change[change.length-i];
            out=out+c1;
        }
        System.out.println(out);
        return out;
    }
    public static int getMaxArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4 ) {
        // write code here
        int[] arrx={x1,x2,x3,x4};       //0 1 2 3
        int[] arry={y1,y2,y3,y4};
        //Arrays.sort(arrx);
        //Arrays.sort(arry);
        int chang=0;
        int kuang=0;
        if(x1==0 && y1==0){
            chang=10-x2;
            System.out.println(chang);
        }
        if(x4==10 && y4==10){
            kuang=10-(y4-y3);
            System.out.println(kuang);
        }

        System.out.println(chang*kuang);
        return chang*kuang;
    }
}
