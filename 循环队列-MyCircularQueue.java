/**
 * @author ：ZXY
 * @date ：Created in 2020/8/25 14:26
 * @description：
 */

public class MyCircularQueue {
    private int f;  //队头
    private int r;  //队尾
    private int[] element;  //数组

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue=new MyCircularQueue(4);
        myCircularQueue.enQueue(1);
        System.out.println(myCircularQueue.Front());    //头
        System.out.println(myCircularQueue.Rear());
        System.out.println("-----------");

        myCircularQueue.enQueue(2);
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Rear());
        System.out.println("-----------");

        myCircularQueue.enQueue(3);
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Rear());
        System.out.println("-----------");

        myCircularQueue.enQueue(4);
        System.out.println(myCircularQueue.Front());
        System.out.println(myCircularQueue.Rear());
        System.out.println("-----------");
    }
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.f=0;
        this.r=0;
        this.element=new int[k];        //k大小数组
    }


    //入队，成功true，失败false
    public boolean enQueue(int value) {
        //判断是否为满
        if(isFull()){
            return false;
        }
        //不满，存在r下标处，r++
        this.element[r]=value;
        this.r=(this.r+1)%this.element.length;      //r+1
        return true;
    }


    //出队，成功true，失败false
    public boolean deQueue() {
        //判断是否为空
        if(isEmpty()){
            return false;
        }
        //不为空，进行出队，f++
        this.f=(this.f+1)%this.element.length;      //f+1
        return true;
    }


    //拿队头元素
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return this.element[f];
    }

    //拿队尾元素
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        //return this.element[r-1];
        int index=(this.r==0)?this.element.length-1:this.r-1;
        return element[index];
    }


    //判断为空
    public boolean isEmpty() {
        if(this.f==this.r){
            return true;
        }
        return false;
    }


    //判断为满
    public boolean isFull() {
        if( (this.r+1) % this.element.length ==this.f){
            return true;
        }
        return false;
    }


}


