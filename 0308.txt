import java.util.Scanner;

/**
 * 出现的概率比较低，如果没有出现，没办法
 * 如果成功的话，一直打印 true，看不到 condition 已经被修改为 false
 */
public class 理论上应该出现可见性问题 {
    private static boolean condition = true;

    private static class PrintCondition extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println(condition);
            }
        }
    }

    public static void main(String[] args) {
        PrintCondition pc = new PrintCondition();
        pc.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        condition = false;  // 一定概率下，pc 线程看不到这个变化
    }
}
