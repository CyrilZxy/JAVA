package 插入排序;

import java.util.Arrays;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/8 9:13
 * @description：
 */

public class Main1 {
    public static void main(String[] args) {

        int[] array1={12,4,6,9,2};
        insertSort(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2={12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        shellSort(array2);
        System.out.println(Arrays.toString(array2));


    }

    //希尔排序
    public static void shellSort(int[] array){
        int[] drr={5,3,1};  //分组
        for (int i = 0; i <drr.length ; i++) {
            shell(array,drr[i]);    //进行分组 并排序
        }
    }
    public static void shell(int[] array,int gap){
        //直接插入排序 更改跨值，gap分组
        for (int i = gap; i <array.length ; i++) {
            int tmp=array[i];
            int j;
            for (j = i-gap; j >=0 ; j-=gap) {
                if(tmp<array[j]){              //排序元素小 要放前面
                    array[j+gap]=array[j];        //比tmp大的后移
                }else{
                    break;       //前面已经有序
                }
            }
            array[j+gap]=tmp;
        }
    }


    //直接插入排序
    public static  void insertSort(int[] array){
        for (int i = 1; i <array.length ; i++) {
            int tmp=array[i];
            int j;
            for (j = i-1; j >=0 ; j--) {
                if(tmp<array[j]){              //排序元素小 要放前面
                    array[j+1]=array[j];        //比tmp大的后移
                }else{
                    break;       //前面已经有序
                }
            }
            array[j+1]=tmp;
        }
    }
}
