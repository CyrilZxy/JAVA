package 多线程;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/13 15:46
 * @description：
 */

//创建线程方式2：
//      实现runnable接口
//      重写run方法
//      执行线程需要丢入runnable接口实现类，调用start
public class TestThread2 implements Runnable{

    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("在学习多线程"+i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程


        //创建runnable接口的实现类对象
        TestThread2 testThread2=new TestThread2();
        //创建线程对象，通过线程对象开启线程，代理
        //Thread thread=new Thread(testThread2);
        //调用start（）方法开启线程
        //thread.start();
        new Thread(testThread2).start();        //合并一行


        for (int i = 0; i < 20; i++) {
            System.out.println("在看主线程啊啊啊啊啊"+i);
        }
    }


}
