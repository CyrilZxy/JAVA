public class exception {
    public static void main(String[] args) {
        System.out.println(divide(10,0));
    }
    public static int divide(int x,int y){
        if (y==0) {
            throw new ArithmeticException("抛出0异常");
        }
        return x/y;
    }
    public static void func2(){
        int[] arr={1,2,3};



    }
}
