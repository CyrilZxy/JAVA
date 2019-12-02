import java.util.Arrays;


/*
1、合并两个有序的数组 如int[] array1 = {1,3,6,9}  int[] array2 = {2,4,6,8}
        合并之后的结果：1,2,3,4,6,6,9
2、字符串转化（压缩）   “aabbccdaa” -> "2a2b2c1d2a"
3、题目： i am student 逆置 为  student  am i

*/
public class T {
    public static void main(String[] args) {

    }


//----------------------------------------------------
    public static void main3(String[] args) {
        String str="i am student";
        func3(str);
    }
    public static void func3(String str){
        char[] arrary=str.toCharArray();
        reverse(arrary,0,arrary.length-1);      //头尾全部逆置
        //System.out.println(Arrays.toString(arrary));

        //单词逐个逆置
        int i=0;        //左
        int j=0;
        while(i<arrary.length){
            if(arrary[i]==' '){
                i++;
                j++;
            }
            if(j==arrary.length-1||arrary[j]==' '){
                reverse(arrary,i,j-1);
                i=++j;
            }
            /*if(j==arrary.length-1){
                reverse(arrary,i,j-1);
                i=++j;
            }*/
            else{
                j++;
            }
        }
        //System.out.println(Arrays.toString(arrary));
        System.out.println(String.copyValueOf(arrary));
    }

    public static void reverse(char[] array,int left,int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
//----------------------------------------------------
    public static void main2(String[] args) {
        String str="aabbccdaa";
        func2(str);

    }
    public static void func2(String str){
        char[] array=str.toCharArray();
        int repCount=1;
        char ch=str.charAt(0);

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)==ch){
                repCount++;
            }else{
                sb.append(repCount).append(ch);
                repCount=1;
                ch=str.charAt(i);
            }
        }

        sb.append(repCount).append(ch);

        System.out.println(sb);
    }

//----------------------------------------------------
    public static void main1(String[] args) {
        int[] array1={1,3,6,9};
        int[] array2={2,4,6,8};
        func1(array1,array2);
    }

    //拼接两有序数组
    public static void func1(int[] array1,int[] array2){
        int length=array1.length+array2.length;
        int[] array=new int[length];
        int i=0;    //array1
        int j=0;    //array2
        int k=0;    //array
        while(i<array1.length && j<array2.length){
            if(array1[i]<=array2[j]){
                array[k++]=array1[i++];
/*                i++;
                k++;*/
            }else{
                array[k++]=array2[j++];
            }
        }

        while(i<array1.length){
            array[k++]=array1[i++];
        }

        while(j<array2.length){
            array[k++]=array2[j++];
        }
        System.out.println(Arrays.toString(array));
    }


}
