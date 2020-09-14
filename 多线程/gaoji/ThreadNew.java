package 多线程.gaoji;

import java.util.concurrent.*;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 22:07
 * @description：
 */

//回顾总结
public class ThreadNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.继承Thread类，直接启动
        new MyThread1().start();
        // 2.实现Runnable接口,传入Thread启动
        new Thread(new MyThread2()).start();

        // 3.实现Callable接口
        MyThread3 callThread=new MyThread3();
        ExecutorService service= Executors.newFixedThreadPool(1);
        Future<Integer> r=service.submit(callThread);
        Integer result1= r.get();
        System.out.println(result1);
        service.shutdown();
        //3.实现Callable接口
        FutureTask<Integer> futureTask=new FutureTask<Integer>(new MyThread3());
        new Thread(futureTask).start();
        Integer result2=futureTask.get();
        System.out.println(result2);


    }


}

// 1.继承Thread类
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("1.继承Thread类");
    }
}

// 2.实现Runnable接口
class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("2.实现Runnable接口");
    }
}

// 3.实现Callable接口
class MyThread3 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("3.实现Callable接口");
        return 100;
    }
}
