

class ListNode{              //节点
    public int data;
    public ListNode next;
    public ListNode prev;
    public ListNode(int data){
        this.data=data;
    }
}

class DoubleList {
    public ListNode head = null;            //头
    public ListNode last = null;            //尾巴  每插入一次标志一次


    //1.头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.head.prev = node;
            node.next = this.head;
            this.head = node;         //头前移
        }
    }

    //2.尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.last == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;         //尾巴后移
        }
    }

    //3.任意位置插入,第一个数据节点为0号下标
    public  void addIndex(int index,int data){
        if (index==0){
            addFirst(data);
            return ;
        }else if(index==size()){
            addLast(data);
            return ;
        }

        ListNode node=new ListNode(data);
        ListNode cur=serchIndex(index);     //cur为要插入的位置节点
        if(cur == null) {
            return ;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;       //先改prev.next，
        cur.prev = node;            //后改prev。  否则prev.next为node.next
    }

    //a.输出显示
    public void display() {
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println(  );
    }

    //b.找到插入位置
    private ListNode serchIndex(int index){
        if(index < 0 || index >= size()) {
            return null;
        }

        ListNode cur=this.head;
        while (index>0){
            cur=cur.next;
            index--;
        }
        return cur;
    }

    //c.得到单链表的长度
    public int size(){
        ListNode cur=this.head;
        int length=0;
        while (cur!=null){
            length++;
            cur=cur.next;
        }
        return length;
    }

//-----------------------------------

    //4.查找是否包含关键字key是否在双向链表当中
    public boolean contains(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //5.删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key) {             //3种情况
                if (cur == this.head) {     //在头时
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {                    //尾巴和中间
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {          //尾巴时
                        this.last = cur.prev;
                    }
                    return ;            //直接结束，删除第一个
                }
            }
             cur=cur.next;
        }
    }

    //6.删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key) {             //3种情况
                if (cur == this.head) {     //在头时
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {                    //尾巴和中间
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {          //尾巴时
                        this.last = cur.prev;
                    }
                    //不return 全部删除
                }
            }
            cur=cur.next;
        }
    }

    //7.删除全部
    public void clear(){
        while(this.head!=null){
            ListNode cur=this.head.next;        //cur始终为head.next
            this.head.next=null;
            this.head.prev=null;
            this.head=cur;
        }
        this.last=null;     //last 也要处理
    }
    //查看清空方法：
    // 1.cmd     2.jps（查看进程号） 3.jmap -histo：live 14272>e:log.txt    4.打开log.txt


}
