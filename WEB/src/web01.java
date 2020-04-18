

/**
 * @author ：ZXY
 * @date ：Created in 2020/4/8 22:02
 * @description：
 */

public class web01 {
    public static void main(String[] args) {
        printResult();
    }

    public static void printResult() {
        for (int i = 0; i < 10; i++) {
            int r=add(i,i+1);
            System.out.println(r);
        }
    }

    private static int add(int i,int j){
        return i+j;
    }

}
