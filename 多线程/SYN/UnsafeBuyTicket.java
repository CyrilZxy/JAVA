package 多线程.SYN;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 12:11
 * @description：
 */


//不安全的买票
//线程不安全，有负数、0、相同数字

public class UnsafeBuyTicket {
    public static void main(String[] args) {

        BuyTicket buyTicket=new BuyTicket();
        Thread thread1=new Thread(buyTicket,"学生党");
        Thread thread2=new Thread(buyTicket,"黄牛");
        Thread thread3=new Thread(buyTicket,"我");

        thread1.start();
        thread2.start();
        thread3.start();


    }
}

class BuyTicket implements Runnable{

    //票
    private int ticketNums=10;
    boolean flg=true;       //外部停止方式

    @Override
    public void run() {
        //买票
        while (flg){
            try {
                buy();
                //模拟演示
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //synchronized 同步方法，锁的是this
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if(ticketNums<=0){
            flg=false;
            return;
        }

        //买票
        System.out.println(Thread.currentThread().getName()+"买到票"+ticketNums--);
    }
}
