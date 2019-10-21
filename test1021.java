



public class test1021 {


    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                    System.out.printf("%d\t",arr[row][col]);
            }
            System.out.println(" ");
        }
    }

        /*int[]arr={1,2,3};
        int[]output=transform(arr);
        printArray(output);*/

        /*int num=0;
        func1(num);
        System.out.println("num="+num);
        int[]arr={1,2,3};
        func2(arr);
        System.out.println("arr[0]="+arr[0]);*/

            //int[]arr={1,2,3};
            //printArray(arr);


            //System.out.println(arr[1]);
            //System.out.println(arr[0]);
            //System.out.println("length:"+arr.length);

        /*for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
        for (int x:arr){
            System.out.println(x);
        }*/


   /* public static int[] transform(int[] arr) {
        int[]ret=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i]=arr[i]*2;
        }
        return ret;
    }

    public static void printArray(int [] a) {
        for (int x:a){
            System.out.println(x);
        }
    }*/

   /*public static void func2(int[] a) {
       a[0]=10;
       System.out.println("a[0]="+a[0]);

   }
    public static void func1(int x) {
        x=10;
        System.out.println("x="+x);
    }*/

}