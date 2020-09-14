package 多线程.FiveStates;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 1:04
 * @description：
 */

//测试Join方法
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip插队来了 "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        //启动哦我们的线程
        TestJoin testJoin=new TestJoin();
        Thread thread=new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 50; i++) {
            if(i==20){
                thread.join();  //插队
            }
            System.out.println("main线程 "+i);
        }

    }
}
