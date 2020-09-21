
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/6 19:04
 * @description：
 */

public class huawei {

    // T3：n*m的网格，每个格子三个数
    //     pD下方格子概率    pR左方格子概率   pS停留原地概率
    //     pD>=0,pR,pS<=1,且pD+pR+pS=1;
    //求左上角移动到右下角步数的期望
    //从 0，0 到 n，m

    //n行 3*m个实数
    //第i行的第3*j,3*j+1,3*j+2 个数表示第i行，第j列格子上 pD   pR   pS
//输入：
/*
2 2
1.0     0.0     0.0   |  0.5     0.0     0.5

0.0     0.5     0.5   |  0.5     0.5     0.0
*/
//输出：
//  3.0
//第1步以100%的概率从(0,O)移动(1, O);
//从(1,O移动到(, 1)所需的期望步数是2步，最终答案为3.


    public static void main(String[] args) {
        //状态转移方程
        //dp[G(i,j)]=   (  dp[G(i+1,j)] ∗d[G(i,j)]  +  dp[G(i,j+1)] ∗ r[G(i,j)]  +1 )   / (1.0−s[G(i,j)]) ;
/*
2 2
1.0 0.0 0.0 0.5 0.0 0.5
0.0 0.5 0.5 0.5 0.5 0.0
*/

        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] arr=str.split(" ");
        int n=Integer.valueOf(arr[0]);
        int m=Integer.valueOf(arr[1]);

//pD下方格子概率    pR左方格子概率   pS停留原地概率
        double[][] pD=new double[100][100];         //  1.0     0.5 ,   0.0     0.5
        double[][] pR=new double[100][100];         //  0.0     0.0,    0.5     0.5
        double[][] pS=new double[100][100];         //  0.0     0.5    0.5     0.0

        double[][] dp=new double[100][100];


        for (int i = 0; i <n ; i++) {
            String line=sc.nextLine();
            String[] arrline=line.split(" ");
            for (int j = 0,y=0; j <arrline.length ; j+=3,y++) {
                double D=Double.parseDouble(arrline[j]);
                double R=Double.parseDouble(arrline[j+1]);
                double S=Double.parseDouble(arrline[j+2]);
                pD[i][y]=D;
                pR[i][y]=R;
                pS[i][y]=S;
            }
        }
        for(int i=n;i>=1;i--)
        {
            for(int j=m;j>=1;j--)
            {
                if(i==n&&j==m) continue;
                dp[i][j]+=(  dp[i+1][j]      *    pD[i][j]
                            +dp[i][j+1]     *    pR[i][j]
                            +1)
                        /
                        ( 1.0 - pS[i][j] )
                       ;
            }
        }

        //System.out.println(dp[1][2]);
        //System.out.println(dp[2][1]);
        System.out.println(dp[n-1][m-1]+dp[n-1][m]);

        //pD  pR  pS


    }



    public static int G(int x,int y,int m)
    {
        return m*(x-1)+y;
    }
//------------------------------------------------------------------------------------------------------------


    // T2：数字规律

    //输入                    特征值
        /*
        list.add("135682318");  //121    !!!!!输出
        list.add("23457");      //2
        list.add("14282123");   //12212
        list.add("14231728");   //1212   !!!!输出
        list.add("3");
        list.add("1724153");    //121
        */
    //输出
    //135682318
    //14231728

    public static void main2(String[] args) {

        Scanner sc=new Scanner(System.in);
        List<String> list=new ArrayList<>();
/*
135682318
23457
14282123
14231728
3
1724153
*/
        while(sc.hasNextLine() ){
            String str=sc.nextLine();
            if(str.equals("")){
                break;
            }
            list.add(str);
        }


        int len=list.size();
        //取倒数第二行
        int x=Integer.valueOf(list.get(len-2));     //3
        //取倒数第一行
        String end=list.get(len-1);                 //1724153  特征值121
        //计算最后一行特征值，并记录
        String endValue=menthod1(end,x);            //1724153  特征值121


        //遍历第一行到倒数第三行，取出特征值，查看是否包含 最后一行特征值 str.startsWith(endValue) 则输出
        for (int i = 0; i <len-2 ; i++) {
            String value=menthod1(list.get(i),x);
            if(value.contains(endValue)){
                System.out.println(list.get(i));
            }
        }

/*
        for(int i=0;i<len-2;i++){
            String X=list.get(i);
            StringBuffer stringBuffer1=new StringBuffer();
            for (int j = 0; j <X.length() ; j++) {
                char c=X.charAt(j);
                int cur=c-'0';
                if(cur<A){
                    stringBuffer1.append(String.valueOf(cur));
                }
            }

            String sb1=stringBuffer1.toString();
            String sb0=stringBuffer0.toString();
            if(sb1.startsWith(sb0)){
                System.out.println(X);
            }
        }
*/
    }
    //计算特征值
    public static String menthod1(String str,Integer x){
        StringBuffer sb=new StringBuffer();      //121
        for (int i = 0; i <str.length() ; i++) {
            int cur=Integer.valueOf(String.valueOf(str.charAt(i)));
            if(cur<x){
                sb.append(String.valueOf(cur));
            }
        }
        return sb.toString();
    }




//------------------------------------------------------------------------------------------------------------


    // T1：字符串差距检测
    //I need book.;I need book 2.
    // (1,5)
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] arr=str.split(";");
        //I need book.;I need book 2.
        //(1,5)
        String str1=arr[0];     //I need book.
        String str2=arr[1];     //I need book 2.
        String[] arr1=str1.split(" ");
        String[] arr2=str2.split(" ");

        int out1=0;
        for (int i = 0; i < arr2.length-1; i++) {
            String k1=String.valueOf(arr1[i]);
            String k2=String.valueOf(arr2[i]);
            if(! k1.equals(k2)){
                out1++;
            }
        }


        int out2=arr2.length+1;
        System.out.println("("+out1+","+out2+")");
    }
}
