import org.omg.CORBA.DATA_CONVERSION;

class LinkedList {

    public ListNode head;       //默认为 null

    public void addFirst(int data) {       //头插法   不带头
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;      //第一次插入
        } else {
            node.next = head;         //node的下一个节点指向head地址
            head = node;              //将head地址变更为node地址
        }
    }

    public void addLast(int data) {      //尾插表
        ListNode cur = this.head;
        ListNode node = new ListNode(data);
        if (head == null) {
            this.head = node;      //第一次插入
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }

    }

    public void display() {          //输出链表
        if (this.head == null) {
            return;
        } else {
            ListNode cur = this.head;
            while (cur != null) {
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
            System.out.println();
        }
        System.out.println();
    }



    //插入到index位置  位置号从0开始记 插入位置有getlength+1个
    // getlength为节点个数    index=0;头插   index=getlength；尾插

    public void addIndex(int index,int data){        //插入位置，插入值

        if(index < 0 || index > getLength()) {  //判断插入位置是否合法
            System.out.print("位置不合法"+"  ");
        }
        else if(index == 0) {             //头插法
            addFirst(data);
        }
        else{
            ListNode prev = searchIndex(index);     //找插入点的 前后
            ListNode node = new ListNode(data);     //new一个节点
            node.next = prev.next;      //新节点next指向 插入点后的next  与插入点后拼接
            prev.next = node;           //插入点的next指向新节点地址   与插入点前拼接
        }

    }

    public int getLength() {            //节点长度 及节点个数
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    private ListNode searchIndex(int index) {        //找到index-1位置的节点
        //prev-->index-1;                               返回当前节点的引用
        ListNode prev = this.head;
        int count = 0;
        while (count < index-1) {
            prev = prev.next;
            count++;
        }
        return prev;
    }

    //查找是否包含关键字key
    public boolean contains(int key){
        ListNode cur=this.head;
        while (cur!=null){
            if(cur.data==key){
                System.out.println("key值地址"+cur);        //找到key值，输出了地址
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //删除值为key的节点
    private ListNode suchPrev(int key) {        //找到删除节点的前驱
        ListNode prev = this.head;
        ListNode del = this.head;

        while (del.data!=key){
            del=del.next;
        }
        System.out.println(del.data +" 地址 "+ del);

        while (prev.next!=del) {        //前驱节点next指向 ！= 删除节点地址
            prev = prev.next;
        }
        //System.out.println(prev.next+" "+prev);
        return prev;
    }
    public void remove(int key){
        ListNode del = this.head;
        if(del.data==key){              //删除值为头节点r
            this.head=head.next;
        }
//        ListNode suchPrev(int key);
//        prev.next=del.next;
    }


    //删除值为key的节点        返回头节点地址
    public ListNode removes(int key){
        if(head==null){     //若一个节点都没有
            return null;    //直接return 空
        }

        ListNode cur = this.head.next;      //cur 在prev后一个节点
        ListNode prev = this.head;

        while (cur!=null){
            if(prev.next.data==key){        //prev的后节点值为key
                prev.next=cur.next;         //prev指向  cur.next  后拼接
                cur=cur.next;               //cur向后移一个节点
            }else{
                prev=cur;           //值不为key时
                cur=cur.next;       //prev  cur  后移 继续循环
            }
        }

        if(this.head.data==key){         //头节点等于key 删除 最后处理
            this.head=this.head.next;
        }
        return head;        //返回头节点地址
    }

/*
    //清空单链表
    public void clear{

    }
 */

    public ListNode removeAllKey (int key){                 //
        // 练习程序
        ListNode cur=this.head.next;
        ListNode prev=this.head;

        while(cur!=null){
            if(cur.data==key){              //值等于key时
                prev.next=cur.next;
                cur=cur.next;
            }
            else{           //不等于时，cur prev 都向后移一个节点
                prev=prev.next;
                cur=cur.next;
            }
        }                                //最后解决头节点问题
        if(head.data==key){             //当头节点值为key时
            this.head=head.next;
        }
        return head;
    }

//    //反转单链表
//    public ListNode reverseList(){
//        ListNode cur=this.head.next;
//        ListNode prev=this.head;
//        ListNode curNext=null;
//        ListNode newHead=null;
//
//        prev.next=null;     //头节点next置为null
//        while (cur.next!=null){
//            curNext=cur.next;
//            cur.next=prev;      //前节点地址给后节点的next
//            prev=cur;           //prev cur curNext 都后移
//            cur=curNext;
//        }
//        if(curNext==null){      //cur后无节点时 cur为最后一个节点
//            newHead=cur;        //新头节点地址为cur
//        }
//        return cur;
//    }
//
//    public void newdisplay(ListNode cur) {          //输出链表
//        if (cur == null) {
//            return;
//        } else {
//            ListNode cur1 = cur;
//            while (cur1 != null) {
//                System.out.print(cur1.data + " ");
//                cur1 = cur1.next;
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//
//
//
    public ListNode middleNode1(){
        int len=getLength()/2;
        ListNode cur=this.head;
        for (int i = 0; i <len; i++) {      // i判断条件
            cur=cur.next;
        }
        return cur;
    }


    public ListNode middleNode2(){       //时间复杂度低
        ListNode fast=this.head;
        ListNode slow=this.head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }


    public ListNode findKthToTail(int k){
        ListNode fast=this.head;
        ListNode slow=this.head;

        if (k<=0||head==null){
            System.out.print("k值越界  null    ");
            return head;
        }

            for (int i = 0; i <k-1; i++) {
                if (fast==null){
                    System.out.print("k值越界  null");
                    return head;
                }else{
                    fast=fast.next;
                }
            }
            while(fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }
                return slow;

    }




}



class ListNode {                      //模板节点 - 类
       public int data;                 //值，下个节点的地址
       public ListNode next;

       public ListNode(int data) {      //构造函数  参数节点的值
           this.data = data;
           this.next = null;
       }
}


