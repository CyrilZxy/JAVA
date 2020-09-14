package 多线程.gaoji;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 18:44
 * @description：
 */

//生产者消费者模型： 利用标志位解决——信号灯法
public class TestPC2 {
    public static void main(String[] args) {
        TV tv=new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }

}

//生产者--》演员
class Player extends Thread{
    TV tv;
    public Player(TV tv){
        this.tv=tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                this.tv.play("一拳超人播放中");
            }else {
                this.tv.play("盗笔播放中");
            }
        }
    }
}


//消费者-》观众
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv=tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}


//产品-》节目
class TV{
    //演员表演，观众等待 T
    //观众观看，演员等待 F

    String voice;
    boolean flag=true;

    public synchronized void play(String voice){
        //观众观看，演员等待
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了:"+voice);
        //通知观众观看
        this.notifyAll();       //通知唤醒
        this.voice=voice;
        this.flag=!this.flag;

    }

    public synchronized void watch(){
        //演员正在表演，观众需等待
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //flag=F    观众观看，演员等待
        System.out.println("观众观看了："+voice);
        //通知演员表演
        this.notifyAll();
        this.flag=!this.flag;

    }


}
