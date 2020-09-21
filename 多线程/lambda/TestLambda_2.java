package 多线程.lambda;

import java.util.List;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/13 23:28
 * @description：
 */


public class TestLambda_2 {

    public static void main(String[] args) {
        //1.lambda表达式简化
        ILove love=(int a)-> {
            System.out.println("i love you --> "+a);
        };
        love.love(0);

        //简化1，去掉参数类型
        love=(a)-> {
            System.out.println("i love you --> "+a);
        };
        love.love(1);

        //简化2，简化括号
        love=a-> {
            System.out.println("i love you --> "+a);
        };
        love.love(2);

        //简化3，去掉花括号
        love=a-> System.out.println("i love you --> "+a);
        love.love(3);

        //总结：
            //只有一行代码，可简化花括号，成为一行
            //前提接口必须是函数式接口（只有一个方法）
            //多个参数也可以去掉参数类型，要去全都去掉，必须加括号

    }
}

interface ILove{
    void love(int a);
}


