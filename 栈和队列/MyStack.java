package 栈和队列;

import java.util.*;

/**
 * @author ：ZXY
 * @date ：Created in 2020/8/14 17:38
 * @description：
 */



import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    public Queue<Integer> que1=new LinkedList<>();
    public Queue<Integer> que2=new LinkedList<>();
    private int usesize;

    /** Initialize your data structure here. */
    public MyStack() {
        this.que1=que1;
        this.que2=que2;
        this.usesize=0;
    }


    //入栈
    public void push(int x) {
        //第一次入栈
        if(que1.isEmpty() && que2.isEmpty()){
            que1.offer(x);
        }
        //第n次入栈，入到不为空的队列中
        else{
            if(que1.isEmpty()!=true){
                que1.offer(x);
            }else if(que2.isEmpty()!=true){
                que2.offer(x);
            }
        }
        usesize++;
    }


    //出栈
    public int pop() {

        if(que1.isEmpty() && que2.isEmpty()){
            //System.out.println("栈为空");
        }

        int out=0;
        //把不为空的的队列出到只剩一个，元素入到另一个空队列中
        if(que1.isEmpty()==false){
            for(int i=0;i<this.usesize-1;i++){
                que2.offer(que1.poll());
            }
            out=que1.poll();
            this.usesize--;
        }
        else{
            for(int i=0;i<this.usesize-1;i++){
                que1.offer(que2.poll());
            }
            out=que2.poll();
            this.usesize--;
        }

        return out;
    }


    //拿栈顶元素
    public int top() {
        if(que1.isEmpty() && que2.isEmpty()){
            //System.out.println("栈为空");
        }

        int out=0;
        //把所有元素移动到另一空队列中，保存最后一个数据值
        if(que1.isEmpty()==false){
            for(int i=0;i<this.usesize;i++){
                out=que1.poll();
                que2.offer(out);
            }
        }
        else{
            for(int i=0;i<this.usesize;i++){
                out=que2.poll();
                que1.offer(out);
            }
        }

        return out;
    }


    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(this.usesize==0){
            return true;
        }
        return false;
    }
}

