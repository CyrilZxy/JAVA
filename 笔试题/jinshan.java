import java.util.Scanner;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/16 19:34
 * @description：
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class jinshan {

//3 5 6 -1 -1 2 7 -1 -1 4 -1 -1 1 9 -1 -1 8 -1 -1
//5 1

//3
//输入。
    //第1行包含一段序列，代表昆虫的序号。每个昆虫有两个子代，若没有子代则用-1代替。
    // （如序列：1 2 -1 -1 3 -1 -1，表示1号昆虫有2、3两个子代而2、3没有子代，类似于二叉树的先序遍历） 。
    //第2行，两个已知带有病毒的昆虫编号，用空格隔开。
//输出
    //表示两只病毒昆虫的最近公共祖先的编号
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] arr=str.split(" ");

        String str2=sc.nextLine();
        String[] arr2=str2.split(" ");

        TreeNode root=new TreeNode(Integer.valueOf(arr[0]));
        TreeNode head=root;

        for (int i = 1; i <arr.length ; i+=2) {
            int x=Integer.valueOf(arr[i]);
            int y=Integer.valueOf(arr[i+1]);
            TreeNode node1=new TreeNode(x);
            TreeNode node2=new TreeNode(y);

            if(x!=-1){
                head.right=node1;
            }
            if(y!=-1){
                head.right=node2;
            }
        }


        for (int i = 0; i <arr.length ; i++) {
            if(arr2[0].equals(arr[i])){
                System.out.println(arr[0]);
            }
        }












    }














    //1
    //1 1 1
    //1 1 2 1 1
    //3


    //1                                 1
    //1 1   1                           2
    //1 1 2     1 1                     3
    //1 1 2 3   2 1 1                   4
    //1 1 2 3 5     3 2 1 1             5
    //1 1 2 3 5 8   5 3 2 1 1           6
    //1 1 2 3 5 8 13    8 5 3 2 1 1     7
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();

        for (int i = 1; i <=x ; i++) {
            menthod1(i);
        }

    }
    public static void menthod1(int x){
        if(x==1){
            System.out.println("1");
            return;
        }
        if (x == 2) {
            System.out.println("1 1 1");
            return;
        }
        int[] arr=new int[x];
        arr[0]=1;
        arr[1]=1;
        for (int i = 2; i <x ; i++) {
            arr[i]=arr[i-2]+arr[i-1];
        }

        for (int i = 0; i <x ; i++) {
            System.out.print(arr[i]+" ");
        }
        for (int j = x-2; j >0 ; j--) {
            System.out.print(arr[j]+" ");
        }
        System.out.println(arr[0]);
    }
}
