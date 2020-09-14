package 多线程;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/13 14:50
 * @description：
 */


//创建线程方式1：
//      继承Thread类，
//      重写run（）方法，
//      调用start开启线程
public class TestThread1 extends Thread{

    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("在学习多线程"+i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建线程对象
        TestThread1 testThread1=new TestThread1();
        //调用start（）方法开启线程
        testThread1.start();


        for (int i = 0; i < 20; i++) {
            System.out.println("在看主线程啊啊啊啊啊"+i);
        }
    }


}
