public class demon {

    public static void main(String[] args) {

        waterFlower(999999);
    }



    //求出0～999999之间的所有“水仙花数”并输出
    public static void waterFlower(int n) {
        for (int i = 0; i <= n ; i++) {
            //1、求位数
            int count = 0;//位数
            int tmp = i;
            while(tmp != 0) {
                count++;
                tmp /= 10;
            }
            //count里面保存的就是当前i的位数
            tmp = i;
            //求tmp的每一个位上的数字
            //123   123%10=3  123/10 %10=2
            //12/10%10=1   1/10=0
            int sum = 0;//次方的和
            while (tmp != 0) {
                sum += Math.pow(tmp%10,count);
                tmp = tmp/10;
            }
            if(sum == i) {
                System.out.println(i);
            }
        }
    }


}
