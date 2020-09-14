package 多线程;

import java.util.concurrent.*;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/13 16:57
 * @description：
 */

//创建线程方式3：
/*      step1:实现Callable接口，需要返回值类型
        step2：重写call方法，需要抛出异常
        step3：创建目标对象
        step4：创建执行服务：ExecutorService ser = Executors.newFixedThreadPool(1);
        step5：提交执行：Future<Boolean> result1= ser.submit(t1);
        step6：获取结果：boolean r1 = result1.get()
        step7：关闭服务：ser.shutdownNow();*/
public class TestThread3 implements Callable<Boolean> {

    @Override
    public Boolean call() {
        System.out.println(Thread.currentThread().getName()+"    Callable线程!!!!");
        return true;
    }

    public static void main(String[] args) throws ExecutionException,InterruptedException{

        TestThread3 callThread1=new TestThread3();
        TestThread3 callThread2=new TestThread3();
        TestThread3 callThread3=new TestThread3();

        //创建执行服务
        ExecutorService ser= Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1=ser.submit(callThread1);
        Future<Boolean> r2=ser.submit(callThread2);
        Future<Boolean> r3=ser.submit(callThread3);

        //获取结果
        boolean result1=r1.get();
        boolean result2=r2.get();
        boolean result3=r3.get();
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        //关闭服务
        ser.shutdown();


        System.out.println("在看主线程啊啊啊啊啊");

    }
}
