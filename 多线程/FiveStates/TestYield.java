package 多线程.FiveStates;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 0:54
 * @description：
 */


//测试礼让线程
public class TestYield {

    public static void main(String[] args) {
        MyYield myYield=new MyYield();

        new Thread(myYield,"A").start();
        new Thread(myYield,"B").start();

    }
}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();       //礼让
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }
}
