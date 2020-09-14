package 多线程.FiveStates;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 10:30
 * @description：
 */


//测试线程优先级
public class TestPriority {
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());

        MyPriority myPriority=new MyPriority();

        Thread thread1=new Thread(myPriority);
        Thread thread2=new Thread(myPriority);
        Thread thread3=new Thread(myPriority);
        Thread thread4=new Thread(myPriority);
        Thread thread5=new Thread(myPriority);
        Thread thread6=new Thread(myPriority);

        //先设置优先级，再启动
        thread1.start();

        thread2.setPriority(1);
        thread2.start();

        thread3.setPriority(4);
        thread3.start();

        thread4.setPriority(Thread.MAX_PRIORITY);       //Thread.MAX_PRIORITY=10
        thread4.start();

        //thread5.setPriority(-1);
        thread5.start();

        //thread6.setPriority(11);
        thread6.start();


    }


}

class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
