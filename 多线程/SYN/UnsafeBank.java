package 多线程.SYN;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 12:24
 * @description：
 */

//不安全的取钱
    //两个人去银行取钱

public class UnsafeBank {
    public static void main(String[] args) {
        Account account=new Account(100,"基金");

        Drawing you=new Drawing(account,50,"你");
        Drawing friend=new Drawing(account,100,"朋友");

        you.start();
        friend.start();
    }

}

//账户
class Account{
    int money;      //余额
    String name;    //卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行：模拟取款
class Drawing extends Thread{
    Account account;    //账户
    //取了多少钱
    int drawingMoney;
    //手里有多少钱
    int nowMoney;

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }

    //取钱操作
    //synchronized 同步方法，锁的是this
    @Override
    public  void run() {

        //synchronized 同步块
        synchronized (account){

            //判断有没有钱
            if(account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }

            //sleep可以放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //余额=余额-取的钱
            account.money=account.money-drawingMoney;
            //手里的钱=手里的钱+取的钱
            nowMoney=nowMoney+drawingMoney;

            System.out.println(account.name+"余额为："+account.money);
            //this.getName()   =    Thread.currentThread().getName()
            System.out.println(this.getName()+"手里的钱："+nowMoney);

        }

    }

}
