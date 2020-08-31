package LIST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：ZXY
 * @date ：Created in 2020/8/31 13:59
 * @description：
 */

//  T1：学生对象放在list中，有属性姓名、班级、成绩。
//      输出：遍历打印所有属性。

public class test1 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(2);
        list.add(8);
        list.add(7);
        list.add(5);
        for (int i = 0; i <list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println("=======排序=======");

        Collections.sort(list);                     //升序
        for (int i = 0; i <list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }

    }
}
