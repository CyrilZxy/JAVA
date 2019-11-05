public class main {
    public static void main(String[] args) {

        LinkedList list=new LinkedList();
        //System.out.println(list.head);
        list.addFirst(24);                 //头插法
       // System.out.println(list.head);          //输出地址的哈希值 头节点变换
        list.addFirst(47);
        //System.out.println(list.head);
        list.addFirst(8);
       //System.out.println(list.head);
        list.addIndex(3,5);
        list.addIndex(1,5);
//        list.addIndex(1,5);
//        list.addIndex(0,5);
        list.addIndex(0,2);
//        list.addIndex(5,2);
//        list.addIndex(4,2);
//        list.addIndex(4,2);
        list.display();


        LinkedList list1=new LinkedList();       //尾插法
        //System.out.println(list1.head);         //输出地址的哈希值 头节点不变
        list1.addLast(100);
        list1.addLast(5);
        //list1.display();
       //list1.addIndex(4,31);
       list1.addIndex(1,31);
       list1.display();

        //list.contains(5);
        //list.remove(8);

        //System.out.println(list.removes(5));
        //list.display();
        //System.out.println(list.removeAllKey(2));


//        System.out.println(list.reverseList());
//        list.newdisplay(list.reverseList());


        //输出链表 中间 节点值
//        System.out.println(list.middleNode1().data);
//        System.out.println(list1.middleNode1().data);
//        System.out.println(list.middleNode2().data);
//        System.out.println(list1.middleNode2().data);

        System.out.println(list.findKthToTail(2).data);
        System.out.println(list.findKthToTail(-10).data);
        System.out.println(list1.findKthToTail(3).data);


    }

}
