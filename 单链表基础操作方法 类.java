import org.omg.CORBA.DATA_CONVERSION;

class ListNode {                      //模板节点 - 类
    public int data;                 //值，下个节点的地址
    public ListNode next;

    public ListNode(int data) {      //构造函数  参数节点的值
        this.data = data;
        this.next = null;
    }
}

class SingleLinkedList {         //无头单向非循环链表

    public ListNode head;       //默认为 null


    //1.头插法   不带头
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;          //第一次插入
        } else {
            node.next = head;         //node的下一个节点指向head地址
            head = node;              //将head地址变更为node地址
        }
    }


    //2.尾插法
    public void addLast(int data) {
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


    //3.插入到index位置  位置号从0开始记 插入位置有getlength+1个
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


    //4.查找是否包含关键字key
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


    //5.删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null) {     //判断链表是否为空
            return;
        }

        if(this.head.data==key){              //头节点值为key时
            this.head=head.next;              //删除头节点
        }else{
            if(searchPrev(key)==null){        //找不到删除节点  即前驱节点为空时
                System.out.println("没有值为"+key+"的节点，无法删除。");
                return;
            }
            ListNode prev=searchPrev(key);          //创建节点，为搜索前驱节点的返回值
            ListNode del=prev.next;              //del节点为prev的next
            prev.next=del.next;             //删除。前驱指向=删除节点指向  拼接删除了del节点
        }
    }
    private ListNode searchPrev(int key) {        //找到删除节点的前驱 返回值为节点类型
        ListNode prev = this.head;

        while (prev.next!=null){      //删除节点的值不等于key时，删除节点向后移
            if(prev.next.data==key){
                return prev;
            }
            prev=prev.next;
        }
        return null;
    }





    //6.删除值为key的所有节点        返回头节点地址
    public ListNode removeAllKey(int key){
        if(head==null){     //若一个节点都没有
            return null;    //直接return 空
        }

        ListNode prev = this.head;
        ListNode cur = this.head.next;      //cur 在prev后一个节点

        while (cur!=null){
            if(cur.data==key){              //cur值为key
                prev.next=cur.next;         //prev指向  cur.next  后拼接
                cur=cur.next;               //cur向后移一个节点
            }else{
                prev=prev.next;           //值不为key时
                cur=cur.next;       //prev  cur  后移 继续循环
            }
        }

        if(this.head.data==key){         //头节点等于key 删除 最后处理
            this.head=this.head.next;
        }
        return head;        //返回头节点地址
    }


    //7.输出链表
    public void display() {
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

    //8.清空单链表
    public void clear(){
        while(this.head.next!=null){
            ListNode cur=this.head.next;
            this.head.next=cur.next;
        }
        this.head=null;
    }
    
    //9.链表长度  sout getLength返回值
    public void size(){
        System.out.println("该链表长度："+getLength());
    }
}
