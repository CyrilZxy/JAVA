package 多线程.SYN;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 12:44
 * @description：
 */

//list线程不安全，add结果不到10000
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                //synchronized 同步方法
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }


        System.out.println(list.size());
    }
}
