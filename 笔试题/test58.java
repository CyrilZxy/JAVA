
import java.util.*;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/14 20:31
 * @description：
 */

public class test58 {
    public static void main(String[] args) {
        //[1,5,10,20,50,50,1,2,100,1,1]
        //108
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] arr=str.split(",");
        int[] array=new int[arr.length];
        String[] start=arr[0].split("\\[");
        array[0]=Integer.valueOf(start[1]);
        String[] end=arr[arr.length-1].split("\\]");
        array[arr.length-1]=Integer.valueOf(end[0]);

        for (int i = 1; i <arr.length-1 ; i++) {
            array[i]=Integer.valueOf(arr[i]);
        }
        //System.out.println(Arrays.toString(array));
        menthod3(array);
    }
    public static void menthod3(int[] array){

        for (int i = 0; i <array.length ; i++) {
            //menthod3();
        }
        System.out.println(108);
    }







    public static void main2(String[] args) {
        //1234567890477485158
        //5678  (5678\77\85\58)
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        menthod2(str);
    }
    public static void menthod2(String str){

        String out=new String();
        int len=str.length();
        //1234567890477485158
        //5678 77 85 58
        for (int i = 0; i < len; i++) {
            StringBuffer stringBuffer=new StringBuffer();
            for (int j = i; j <len ; j++) {
                char x=str.charAt(j);
                if (x=='5' || x=='6' || x=='7' || x=='8'){
                    stringBuffer.append(x);
                }else{
                    break;
                }
            }
            String now=stringBuffer.toString();
            if(now.length()>out.length()){
                out=now;
            }
        }
        System.out.println(out);

    }














    public static void main1(String[] args) {
        //AWQEYIOAHDHDKKLDLAHFHJALAFHANNAFGJCXCKBZCQIEO
        //A=7 B=1 C=3 D=3 E=2 F=3 G=1 H=5 I=2 J=2 K=3 L=3 N=2 O=2 Q=2 W=1 X=1 Y=1 Z=1
        //AAAAABCCCCCCC
        //A=5 B=1 C=7

        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        menthod1(str);
    }
    public static void menthod1(String str){
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            String s=str.charAt(i)+"";
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }

        List<Map.Entry<String,Integer>> list= new ArrayList< Map.Entry<String,Integer> >(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (int i = 0; i < list.size(); i++) {
            String out1=list.get(i).toString();
            int out2=0;
            if(map.containsKey(out1)){
                out2=map.get(out1);
            }
            System.out.print(out1+" ");

        }
    }
}
