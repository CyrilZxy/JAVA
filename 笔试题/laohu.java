import java.util.*;

/**
 * @author ：ZXY
 * @date ：Created in 2020/8/30 16:38
 * @description：    老虎
 */

public class laohu {

    //输入：        3
    //              1 90
    //              2 87
    //              3 92
    //输出(升序)：  2 87
    //              1 90
    //              3 92
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int nums=sc.nextInt();
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i <nums ; i++) {
            int number=sc.nextInt();
            int score=sc.nextInt();
            map.put(number,score);      //录入学号，成绩
        }

        //按value(成绩)排升序
        List<Map.Entry<Integer,Integer>> list=new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //return 0;
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for(Map.Entry<Integer,Integer> mapout:list){
            System.out.println(mapout.getKey()+" "+mapout.getValue());
        }
    }



//----------------------------------------------------------------------------------
    /*//输入：   They are students.
    //         aeiou
    //输出：   Thy r stdnts.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        delete(str1,str2);
    }
    public static void delete(String str1,String str2){

        HashSet<Character> set=new HashSet<>();

        for(int i=0;i<str2.length();i++){       //录入需要剔除的元素
            set.add(str2.charAt(i));
        }

        for(int j=0;j<str1.length();j++){
            if(set.contains(str1.charAt(j))){   //str1存在该元素不输出
                ;
            }else{                              //不存在输出
                System.out.print(str1.charAt(j));
            }
        }
    }

*/

}
