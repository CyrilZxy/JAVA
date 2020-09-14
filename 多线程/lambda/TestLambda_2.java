package 多线程.lambda;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/13 23:28
 * @description：
 */




public class TestLambda_2 {

}

interface ILove{
    void love(int a);
}

class Love implements ILove{
    @Override
    public void love(int a) {
        System.out.println("i love you");
    }
}
