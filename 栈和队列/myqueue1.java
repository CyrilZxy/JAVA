package 栈和队列;

/**
 * @author ：ZXY
 * @date ：Created in 2020/8/22 22:28
 * @description：    链表实现队列
 */
class Node{
    public int data;
    public Node next;
    public Node(){}
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class myqueue1 {
    public Node front;
    public Node rear;
    public int usedsize;

    public void offer(int data){
        Node node=new Node(data);
        //第一次插入
        if(this.front==null){
            this.front=node;
            this.rear=node;
            this.usedsize=1;
            return;
        }
        this.rear.next=node;
        this.rear=node;
        this.usedsize++;
    }
    public void poll(){
        if(empty()){
            System.out.println("队列为空");
            return;
        }
        int data=this.front.data;
        this.front=this.front.next;
        this.usedsize--;
        System.out.println(data);
    }
    public void peek(){
        if(empty()){
            System.out.println("队列为空");
            return;
        }
        int data=this.front.data;
        System.out.println(data);
    }
    public boolean empty(){
        if(this.usedsize==0){
            return true;
        }
        return false;
    }

}
