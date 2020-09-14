package 多线程;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/13 21:56
 * @description：
 */

public class StaticProxy {
    public static void main(String[] args) {

        new Thread(()-> System.out.println("love")).start();

        new WeddingCompany(new You()).HappyMarry();

        //You you=new You();
        //WeddingCompany weddingCompany=new WeddingCompany(you);
        //wedingCompany.HappyMarry();
    }

}
interface Marry{

    void HappyMarry();
}
//真实角色
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("you结婚超开心");
    }
}
//代理角色，帮助你结婚
class WeddingCompany implements Marry{

    //代理  真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();       //这就是真实对象
        after();

    }

    private void before() {
        System.out.println("结婚前，布置现场");
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }
}