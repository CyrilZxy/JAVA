package 选择排序;

import java.util.Arrays;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/8 10:58
 * @description：
 */

public class Main2 {

    public static void main(String[] args) {

        int[] array1 = {12, 4, 6, 9, 2};
        //selectSort(array1);
        heapSort(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {12, 5, 9, 34, 6, 8, 33, 56, 89, 0, 7, 4, 22, 55, 77};
        //selectSort(array2);
        heapSort(array2);
        System.out.println(Arrays.toString(array2));


        //堆排序
/*        TestHeap testHeap = new TestHeap();
        int[] array = {27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        testHeap.creatHeap(array);      //大根堆
        testHeap.show();
        testHeap.headSort();            //输出从小到大
        testHeap.show();*/
    }
    //堆排序
    public static void heapSort(int[] array){
        //1.创建大根堆
        creatHeap(array);
        //2.堆顶元素和最后一个元素交换
        int end=array.length-1;
        while (end>0){
            int tmp=array[0];
            array[0]=array[end];
            array[end]=tmp;
            adjustDown(array,0,end);
            end--;
        }
    }
    //1.创建大根堆
    public static void creatHeap(int[] array){
        // i 表示每棵子树的根节点
        for(int i=(array.length-1-1)/2;i>=0;i--){
            adjustDown(array,i,array.length);
        }
    }
    //向下调整  root每棵子树根节点  len每棵子树结束位置
    public static void adjustDown(int[] array,int root,int len){
        int parent=root;
        int child=2*parent+1;
        while (child<len){
            //1、找到左右孩子的最大值
            if((child+1<len) && array[child]<array[child+1]){
                child=child+1;
            }
            //child保存左右孩子最大值下标

            if(array[child]>array[parent]){
                int tmp=array[child];
                array[child]=array[parent];
                array[parent]=tmp;
                parent=child;
                child=2*parent+1;
            }else{
                //不需进行调整
                break;
            }
        }
    }







    //直接选择排序
    public static void selectSort(int[] array){
        for (int i = 0; i <array.length ; i++) {
            for (int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){      //找到比当前元素小的要交换两元素
                    int tmp=array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }
}