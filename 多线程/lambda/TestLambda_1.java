package 多线程.lambda;

import java.util.List;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/13 22:44
 * @description：
 */


//推导lambda表达式
public class TestLambda_1 {




    public static void main(String[] args) {

        ILike like=new Like1();    //1.实现类
        like.lambda();


        like=new Like2();          //2.静态内部类
        like.lambda();


        //3.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("i like lambda 333");
            }
        }
        like=new Like3();           //3.局部内部类
        like.lambda();


        //4.匿名内部类,没有类的名称，必须借助接口或者父类
        like=new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda 4444");
            }
        };
        like.lambda();              //4.匿名内部类


        //5.用lambda简化
        like=()->{
                System.out.println("i like lambda 55555");
            };
        like.lambda();              //5.用lambda简化 + 0.函数式接口

    }


    //2.静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("i like lambda 22");
        }
    }


}

//0.定义一个函数式接口,只包含唯一一个抽象方法的接口
interface ILike{
    void lambda();
}

//1.实现类
class Like1 implements ILike{
    @Override
    public void lambda() {
        System.out.println("i like lambda 1");
    }
}