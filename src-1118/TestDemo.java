

public class TestDemo {

    public static void main(String[] args) {
        DoubleList list1=new DoubleList();
        list1.addFirst(0);          //头插
        list1.addFirst(13);
        list1.addLast(7);           //尾插
        list1.addLast(26);
        list1.addIndex(0,35);       //任意位置插入
        list1.addIndex(4,13);
        list1.addIndex(1 ,7);
        list1.display();
        System.out.println(list1.contains(2));      //查找key值节点
        System.out.println(list1.contains(7));
        list1.remove(13);       //删除第一个值为key节点
        list1.display();
        list1.removeAllKey(7);      //所有删除值为key节点
        list1.display();
        list1.clear();

    }

}
