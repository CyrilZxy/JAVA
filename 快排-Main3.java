package 交换排序;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/8 11:41
 * @description：
 */

public class Main3 {
    public static void main(String[] args) {
        int[] array1 = {12, 4, 6, 9, 2};
        //bubbleSort(array1);
        quickSort2(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {12, 5, 9, 34, 6, 8, 33, 56, 89, 0, 7, 4, 22, 55, 77};
        //bubbleSort(array2);
        quickSort2(array2);
        System.out.println(Arrays.toString(array2));
    }
    //快速排序
    public static void quickSort(int[] array){
        quick2(array,0,array.length-1);
    }



    //非递归实现快排
    public static void quickSort2(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {
                continue;
            }
            int pivotIndex = partition(array, left, right);
            stack.push(right);
            stack.push(pivotIndex + 1);
            stack.push(pivotIndex - 1);
            stack.push(left);
        }
    }

    //优化2
    public static void quick2(int[] array,int start,int end){
        if (start >= end) {
            return;
        }
        //优化1
        if(end-start<=100){
            insert_Sort(array,start,end);
            return;
        }

        //优化2   三数取中
        //功能: 让start下标的值尽可能能够在下面的partion函数当中﹑能够均匀的划分待排序序列
        SelectPivotMedianOfThree(array,start,end);

        int pivotIndex = partition(array,start,end);   //基准值最终停留的下标
        // [left, pivotIndex - 1] 都是小于等于基准值的
        // [pivotIndex + 1, right] 都是大于等于基准值的
        quick2(array, start, pivotIndex - 1);
        quick2(array, pivotIndex + 1, end);
    }


    /*函数作用：取待排序序列中low、mid、high三个位置上数据，选取他们中间的那个数据作为枢轴*/
    public static int SelectPivotMedianOfThree(int arr[],int low,int high) {
        int mid = low + ( (high - low)/2 );        //计算数组中间的元素的下标

        //使用三数取中法选择枢轴
        //mid<left<right
        if (arr[mid] > arr[high])//目标: arr[mid] <= arr[high]
        {
            swap(arr,mid,high);
        }
        if (arr[low] > arr[high])//目标: arr[low] <= arr[high]
        {
            swap(arr,low,high);
        }
        if (arr[mid] > arr[low]) //目标: arr[low] >= arr[mid]
        {
            swap(arr,mid,low);
        }
        //此时，arr[mid] <= arr[low] <= arr[high]
        return arr[low];
        //low的位置上保存这三个位置中间的值
        //分割时可以直接使用low位置的元素作为枢轴，而不用改变分割函数了
    }
    public static void swap(int[]array,int x1,int x2){
        int tmp=array[x1];
        array[x1]=array[x2];
        array[x2]=tmp;
    }









    //优化1
    public static void quick1(int[] array,int start,int end){
        if (start >= end) {
            return;
        }

        //优化
        if(end-start<=100){
            insert_Sort(array,start,end);
            return;
        }

        int pivotIndex = partition(array,start,end);   //基准值最终停留的下标
        // [left, pivotIndex - 1] 都是小于等于基准值的
        // [pivotIndex + 1, right] 都是大于等于基准值的
        quick1(array, start, pivotIndex - 1);
        quick1(array, pivotIndex + 1, end);
    }
    //直接插入排序
    public static void insert_Sort(int[] array,int start,int end){
        for (int i = start; i <=end ; i++) {
            int tmp=array[i];
            int j;
            for (j = i-1; j >=start ; j--) {
                if(tmp<array[j]){              //排序元素小 要放前面
                    array[j+1]=array[j];        //比tmp大的后移
                }else{
                    break;       //前面已经有序
                }
            }
            array[j+1]=tmp;
        }
    }








    public static void quick(int[] array,int start,int end){
        if (start >= end) {
            return;
        }

        // pivotIndex 代表基准值最终停留的下标
        int pivotIndex = partition(array,start,end);

        // [left, pivotIndex - 1] 都是小于等于基准值的
        // [pivotIndex + 1, right] 都是大于等于基准值的
        quick(array, start, pivotIndex - 1);
        quick(array, pivotIndex + 1, end);
    }



    //分割排序
    public static int partition(int[] array,int left,int right){
        //选择 array[left] 作为基准值
        int tmp=array[left];
        while(left<right){
            //1.在后面找比tmp小的数据
            while(left<right && array[right]>=tmp){
                right--;
            }
            if(left>=right){
                break;
            }
            if(array[right]<tmp){
                array[left]=array[right];
            }
            //2.在前面找比tmp大的数据
            while(left<right && array[left]<=tmp){
                left++;
            }
            if(left>=right){
                break;
            }
            if(array[left]>tmp){
                array[right]=array[left];
            }
        }
        array[left]=tmp;
        return left;
    }





    //冒泡排序
    public static void bubbleSort(int[] array){
        boolean flg=false;
        for(int i=0;i<array.length-1;i++){
            flg=false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    flg=true;
                }
            }
            if(!flg){     //此次未交换元素
                break;          //直接结束，已经有序了。
            }
        }
    }
}
