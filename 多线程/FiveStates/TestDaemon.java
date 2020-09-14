package 多线程.FiveStates;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 11:05
 * @description：
 */

//测试守护线程
//上帝守护你
public class TestDaemon {
    public static void main(String[] args) {
        God god=new God();
        You you=new You();

        //设置线程为守护线程
        Thread thread=new Thread(god);
        thread.setDaemon(true);     //false用户线程，线程默认为用户线程

        //上帝开始守护
        thread.start();

        //你 用户线程启动
        new Thread(you).start();

    }

}

//上帝
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑着你");
        }
    }
}

//你
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <365 ; i++) {
            System.out.println("你开心活着");
        }
        System.out.println("=====goodbye! world!=====");
    }
}

