/**
 * @author ：ZXY
 * @date ：Created in 2020/9/12 14:18
 * @description：
 */

public class haoweilai {
    public static void main(String[] args) {
        climbStairs(3);
    }
    public static int climbStairs (int n) {
        // write code here
        if(n==1 || n==2 || n==3){
            return n;
        }
        int f1=1;
        int f2=2;
        int out=0;
        for (int i = 3; i <=n; i++) {
            out=f2+f1;
            f2=f1;
            f1=out;
        }
        System.out.println(out);
        return out;
    }
}