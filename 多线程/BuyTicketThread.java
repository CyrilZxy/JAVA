package 多线程;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/13 16:08
 * @description：
 */

//多个线程操作同一个对象
//买火车票

//发现问题：多个线程操作同一个资源，线程不安全，数据紊乱
public class BuyTicketThread implements Runnable{

    //票数
    private int ticketNums=10;

    @Override
    public void run() {
        while (true){
            if(ticketNums<=0){
                break;
            }
            //模拟延时
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--》拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        BuyTicketThread ticketThread=new BuyTicketThread();

        new Thread(ticketThread,"老师").start();
        new Thread(ticketThread,"小明").start();
        new Thread(ticketThread,"黄牛党").start();
    }
}
