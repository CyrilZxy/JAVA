package 多线程.Lock;

import java.util.List;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 15:44
 * @description：
 */

//死锁：多个线程互相抱着对方需要的资源，然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1=new Makeup(0,"灰姑娘");
        Makeup g2=new Makeup(1,"白雪公主");

        g1.start();
        g2.start();
    }


}

//口红
class Lipstick{

}

//镜子
class Mirror{

}

class Makeup extends Thread{

    //需要资源只有一份，用static保证只有一份
    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();

    int choice;     //选择
    String name;    //人名

    Makeup(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if(choice==0){
            //获得口红的锁
            synchronized (lipstick){
                System.out.println(this.name+"获得口红的锁");
                Thread.sleep(1000);
            }
            //1s后获得镜子的锁
            synchronized (mirror){
                System.out.println(this.name+"获得镜子的锁");
            }

        }else{
            //获得镜子的锁
            synchronized (mirror){
                System.out.println(this.name+"获得镜子的锁");
                Thread.sleep(2000);
            }
            //2s后获得口红的锁
            synchronized (lipstick){
                System.out.println(this.name+"获得口红的锁");
            }

        }
    }
}