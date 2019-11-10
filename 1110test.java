

	//6. 以给定值x为基准将链表分割成两部分，
    // 所有小于x的结点排在大于或等于x的结点之前 。顺序不变 尾插法
    public ListNode parrtiton(int x){
        ListNode cur=this.head;
        ListNode bs=null;
        ListNode be=null;
        ListNode as=null;
        ListNode ae=null;
        while (cur!=null){
            if (cur.data<x){
                if (bs==null){      //第一次插入
                    bs=cur;
                    be=bs;

                }else{
                    be.next=cur;
                    be=cur;
                }

            }else{
                if (as==null) {      //第一次插入
                    as = cur;
                    ae = as;
                }else{
                    ae.next=cur;
                    ae=cur;
                }
            }
            cur=cur.next;
        }
        if(bs==null){  //没有小于x的节点
            return as;
        }
        be.next=as;
        if (as!=null){
            ae.next=null;
        }
        return bs;
    }


    //7. 在一个排序的链表中，存在重复的结点，
    // 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    public ListNode deleteDuplication(){
        ListNode cur = this.head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        if(this.head == null) {     //如果头节点为空 直接return
            return null;
        }
        while (cur != null) {
            //cur.next不可为空  判断cur是否与后节点重复
            if(cur.next != null && cur.data == cur.next.data) {
                while(cur.next != null && cur.data == cur.next.data){
                    //循环连续多个节点重复 判断
                    cur=cur.next;       //cur移到后节点  此时cur存在过重复
                }
                cur=cur.next;   //后移cur，重复节点全部移除
            }
            else {
                tmp.next=cur;
                tmp=tmp.next;
                cur=cur.next;   //后移cur
            }
        }
        tmp.next=null; //当尾节点为重复节点时，要将tmp.next置为空
        return  newHead.next;
    }