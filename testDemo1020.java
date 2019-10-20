import java.util.Arrays;

public class testDemo1 {


    public static void main(String[] args) {
        int[]array={20,9,10,-1,-2,0,1,2,4,5,6};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
    }

    public static void bubbleSort(int[] array) {                //冒泡排序
        //次数
        for (int i = 0; i < array.length-1; i++) {
            //趟数
            boolean change=false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    change=true;
                }
            }
            if (change==false){         //此趟没有更改数组元素顺序，则说明数组是有序的。
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //public static int find(int[]array) {}

    /*public static int binarySearch(int[]array,int key,int left,int right){

        if(left>right){
            return -1;
        }
        int mid=(left+right)>>1;
        if(array[mid]==key){
            return mid;
        }
    }*/


    public static void main4(String[] args) {

        int[]array={-1,-2,0,1,2,4,5,6};
        System.out.println(Arrays.toString(array));
        func(array);
        System.out.println(Arrays.toString(reverse(array)));
    }

    public static void func(int[]array) {       //max min avg
        int[] maxArray=new int[1];
        maxArray[0]=array[0];
        int[] minArray=new int[1];
        minArray[0]=array[0];
        double avg=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>maxArray[0]){
                maxArray[0]=array[i];
            }
            if(array[i]<minArray[0]){
                minArray[0]=array[i];
            }
            avg=avg+array[i];
        }
        avg=avg/(array.length);
        System.out.print("maxArray=");
        System.out.println(Arrays.toString(maxArray));
        System.out.print("minArray=");
        System.out.println(Arrays.toString(minArray));
        System.out.println("avg="+avg);
    }

    public static int[] reverse (int[]array) {      //reverse
        int[]reverse=new int[array.length];
        int length=array.length;
        //System.out.println(length);
        for (int i = 0; i < array.length; i++) {
            reverse[i]=array[length-1];
            length=length-1;
        }
        return reverse;
        //System.out.println(Arrays.toString(reverse));

    }


    public static void main3(String[] args) {
        int[] array2={1,2,3,4,5,6};
        System.out.println(Arrays.toString(array2));
        System.out.println(toString(array2));
    }
    public static String toString(int[] array2) {

        String strOut="[";
        for (int i = 0; i < array2.length; i++) {
            //System.out.println(array2[i]);
            if(i==array2.length-1){
                strOut+=array2[i];
            }else {
                strOut+=array2[i]+", ";
            }
        }
        strOut=strOut+"]";
        return strOut;
    }




    public static void main2(String[] args) {
        int[] array2={1,2,3,4,5,6};
        System.out.println(Arrays.toString(array2));

        //System.out.println(array2.length);
        //System.out.println(array2);     //哈希码

        System.out.println(Arrays.toString(transform(array2)));

    }
    public static int[] transform(int[]array3) {
        //System.out.println(array3.length);

        System.out.println(Arrays.toString(array3));
        for (int i = 0; i <array3.length ; i++) {
            array3[i]=2*array3[i];
        }
        return array3;
    }




    public static void main1(String[] args) {

        int a=10;
        System.out.println(a);      //a=10
        func1(a);                   //按值传递
        System.out.println(a);      //a=10  x=20 x为新开辟的空间，为拷贝

        int[] array={1,2,3,4};
        System.out.println(Arrays.toString(array));     //[1, 2, 3, 4]
        func2(array);                                   //引用  地址
        System.out.println(Arrays.toString(array));     //[99, 2, 3, 4]
    }
    public static void func1 (int x) {
        x=20;
    }
    public static void func2 (int[] array) {
        array[0]=99;
    }
}
