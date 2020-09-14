package 多线程.FiveStates;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 0:37
 * @description：
 */

//模拟倒计时     打印系统时间
public class TestSleep2 {

    public static void main(String[] args) {

        //打印当前系统时间
        Date startTime=new Date(System.currentTimeMillis());        //获取当前系统时间
        while (true){
            try{
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime=new Date(System.currentTimeMillis());     //更新时间
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

        //模拟倒计时
        /*try{
            tenDown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }*/
    }

    //模拟倒计时
    public static void  tenDown() throws InterruptedException {
        int num=10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0){
                break;
            }
        }
    }
}
