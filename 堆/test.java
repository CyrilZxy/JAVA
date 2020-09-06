
package 堆;

import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 * @author ：ZXY
 * @date ：Created in 2020/8/25 23:33
 * @description：
 */


public class test {

    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        testHeap.creatHeap(array);
        testHeap.show();
    }



/*
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue1=new PriorityQueue<>();
        priorityQueue1.offer(1);
        priorityQueue1.offer(2);
        System.out.println(priorityQueue1);
        PriorityQueue<Integer> priorityQueue2=new PriorityQueue<>(20);
        ArrayList<Integer> arrayList=new ArrayList<>();
        PriorityQueue<Integer> priorityQueue3=new PriorityQueue<>(arrayList);


    }
    public int[] smallestK(int[] array,int k){
        if(array==null || k<=0){
            return null;
        }

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(int i=0;i<array.length;i++){
            priorityQueue.offer(array[i]);
        }
        int[] ret=new int[k];
        for(int j=0;j<k;j++){
            ret[j]=priorityQueue.poll();
        }
        return ret;
    }*/

}

