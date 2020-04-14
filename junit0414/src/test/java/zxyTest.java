import org.junit.*;

import static org.junit.Assert.*;

public class zxyTest {

    @AfterClass             //创建类的实例后   ！！！必须是静态方法
    public static void afterclass(){
        System.out.println("----------AfterClass");
    }
    @BeforeClass            //创建类的实例前
    public static void beforeclass(){
        System.out.println("----------BeforeClass");
    }



    @After                                          //可用来清理工作
    public void after(){
        System.out.println("----------After");
    }

    @Before                                         //可用来初始化数据
    public void before(){
        System.out.println("----------Before");
    }


    //@Test
    public void add() {
        zxy a=new zxy();
        int res=a.add(10,20);
        System.out.println(res);
    }

    @Test
    public void add1(){
        zxy a=new zxy();
        System.out.println("类的实例创建完成");
        int res=a.add(10,zxy.a);
        zxy.a++;
        System.out.println(res);
        System.out.println(zxy.a);
    }

}