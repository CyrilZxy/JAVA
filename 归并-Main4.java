package 归并排序;

import java.util.Arrays;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/9 14:17
 * @description：
 */

public class Main4 {
    public static void main(String[] args) {
        int[] array1 = {12, 4, 6, 9, 2};
        mergeSort(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {12, 5, 9, 34, 6, 8, 33, 56, 89, 0, 7, 4, 22, 55, 77};
        mergeSort(array2);
        System.out.println(Arrays.toString(array2));
    }

    //非递归实现归并排序




    //归并排序
    public static void mergeSort(int[] array){
        mergerSortInternal(array,0,array.length);
    }
    //分解到只剩单个元素
    public static void mergerSortInternal(int[] array,int low,int high){
        if(low>=high-1){      //截至条件 分解完毕
            return;
        }

        int mid=(low+high)/2;
        mergerSortInternal(array,low,mid);
        mergerSortInternal(array,mid,high);

        //合并
        merge(array,low,mid,high);

    }
    //进行合并
    public static void merge(int[] array, int low, int mid, int high) {
        int s1=low;         //第一个归并段开始
        int s2=mid;       //第二个归并段开始
        int length = high - low;
        int[] tmp = new int[length];      //归并段合并后的数组大小
        int k = 0;          //临时数组的tmp 下标

        //保证两个归并段都有数据 选择小的放入 tmp
        while (s1 < mid && s2 < high) {
            // 加入等于，保证稳定性
            if (array[s1] <= array[s2]) {
                tmp[k++] = array[s1++];
            } else {
                tmp[k++] = array[s2++];
            }
        }

        //第一个归并段还有数据
        while (s1 < mid) {
            tmp[k++] = array[s1++];
        }
        //第二个归并段还有数据
        while (s2 < high) {
            tmp[k++] = array[s2++];
        }

        //把临时数组内的数据 拷贝到原有的数组中 ，从 tmp 搬移回 array
        for (int t = 0; t < length; t++) {
            // 需要搬移回原位置，从 low 开始
            array[low + t] = tmp[t];
        }

    }


}
