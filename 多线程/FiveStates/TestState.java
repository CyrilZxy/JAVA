package 多线程.FiveStates;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 10:17
 * @description：
 */

//观察线程状态
public class TestState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("================");
        });


        //观察状态
        Thread.State state=thread.getState();
        System.out.println(state);          //new

        //观察启动后
        thread.start();             //run
        state=thread.getState();
        System.out.println(state);

        //线程不终止刷新线程状态
        while (state!=Thread.State.TERMINATED){
            Thread.sleep(1000);
            state=thread.getState();        //更新线程状态
            System.out.println(state);      //输出线程状态
        }
    }
}
