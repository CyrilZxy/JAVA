




//根据年龄, 来打印出当前年龄的人是
//少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上) 

public class T1{
	public static void main (String []args){
		int age=48;
		
		System.out.println("此人年龄为："+age);
		
		if(age<18){
			System.out.println("当前年龄为少年");
		}else if(age<=28){
			System.out.println("当前年龄为青年");
		}else if(age<=55){
			System.out.println("当前年龄为中年");
		}else if(age>=56){
			System.out.println ("当前年龄为老年");
		}
		
		
		
		
	}
}