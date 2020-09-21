import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/16 21:48
 * @description：
 */

public class hw3 {


    //dp[G(i,j)]   =(  dp[G(i+1,j)]∗d[G(i,j)]   +    dp[G(i,j+1)]∗r[G(i,j)]   +1 )   /  (  1.0−s[G(i,j)]  );


    //  应评论区要求解释下1 / ( 1.0 − s [ G ( i , j ) ] ) 1/(1.0-s[G(i,j)])1/(1.0−s[G(i,j)])的含义…
    //  比如每次有0.5的概率走出格子，那么期望需要2次才能走出这个格子。
    //  每次有1/3的概率走出格子，期望需要3次走出该格子。（帮助大家理解举的例子…）
    //  那么考虑每次有p的概率走出格子，则期望需要1/p次走出这个格子。
    //  故得到上面式子的1 / ( 1.0 − s [ G ( i , j ) ] ) 1/(1.0-s[G(i,j)])1/(1.0−s[G(i,j)])

    public static double []d=new double[100005];
    public static double []r=new double[100005];
    public static double []s=new double[100005];

    public static double []dp=new double[100005];
    public static int n,m;

    public static int G(int x,int y)
    {
        return m*(x-1)+y;
    }

    public static void main(String[] args)
    {
        Scanner S=new Scanner(System.in);
        n=S.nextInt(); m=S.nextInt();
        for(int i=1;i<=n;i++) for(int j=1;j<=m;j++)
        {
            d[G(i,j)]=S.nextDouble();
            r[G(i,j)]=S.nextDouble();
            s[G(i,j)]=S.nextDouble();
        }
        for(int i=n;i>=1;i--)
        {
            for(int j=m;j>=1;j--)
            {
                if(i==n&&j==m) continue;
                dp[G(i,j)]=(dp[G(i+1,j)]*d[G(i,j)]+dp[G(i,j+1)]*r[G(i,j)]+1)/(1.0-s[G(i,j)]);
            }
        }
        System.out.println(dp[1]);
    }



}