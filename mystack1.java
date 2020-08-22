/**
 * @author ：ZXY
 * @date ：Created in 2020/8/22 22:01
 * @description：    实现一个栈
 */

public class mystack {
    public static void main(String[] args) {
        mystack s=new mystack();
        s.push(1);
        s.push(2);
        s.peek();
        s.pop();
        s.peek();
    }
    private int[] elem;
    private int usedsize;

    public mystack(){
        this.elem=new int[10];
        this.usedsize=0;
    }

    public void push(int val){
        if(isFull()){
            return;
        }
        this.elem[this.usedsize]=val;
        this.usedsize++;
    }
    public void pop(){
        if (empty()){
            System.out.println("栈为空");
        }
        int data=this.elem[this.usedsize-1];
        this.usedsize--;
        System.out.println(data);
    }
    public void peek(){
        if (empty()){
            System.out.println("栈为空");
        }
        int data=this.elem[this.usedsize-1];
        System.out.println(data);
    }
    public boolean empty(){
        if(this.usedsize==0){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if(this.usedsize==this.elem.length){
            return true;
        }
        return false;
    }
}
