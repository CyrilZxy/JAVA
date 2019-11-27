public class Test1127 {

    public static void main(String[] args) {

        String str = "1a23456";
        System.out.println(func(str));

    }

    public static boolean func(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

}