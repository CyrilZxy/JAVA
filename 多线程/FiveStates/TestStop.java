package 多线程.FiveStates;

import 多线程.RaceThread;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 0:08
 * @description：    线程停止
 */

//测试stop
//
public class TestStop implements Runnable {

    //1.设置标志位
    private boolean flag=true;

    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("run.....Thread "+i);
            i++;
        }
    }

    //2.设置一个公开的方法停止线程，转换标志位
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        TestStop testStop=new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main线程 "+i);
            if(i==90){
                //调用自己写的stop方法，切换标志位，让线程停止
                testStop.stop();
                System.out.println("线程停止了！！！");
            }
            
        }
    }
}
