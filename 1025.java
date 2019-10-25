

public class Test {
	

	
	
	public static void main6(String[] args) {
		
		//面试问题：能做switch()参数的有哪些类型？
		//byte  char  short  int   String  枚举
		
		//不能做switch参数的类型：long  float  double
		//boolean   
		
		
		String  a = "hello";
		switch(a) {
			case "hello":
				System.out.println("1");
				break;
			case "bit":
				System.out.println("2");
				break;
			default:
				System.out.println("error");
				break;
		}
		
		
	}
	
	public static void main5(String[] args) {
		
		int x = 20;
		int y = 10;
		if (x == 10) {
			if (y == 10) {
				System.out.println("aaa");
			}else {
				System.out.println("bbb");
			}	
		}
			
		
		/*
		int a = 10;
		//if(布尔表达式)
		if(a > 10){
			System.out.println("a > 10");
		}else if(a == 10){
			System.out.println("a == 10");
		}else {
			System.out.println("a < 10");
		}
		
		int b = 10;
		if(b > 10){
			System.out.println("b == 10");
		}
		*/
		
	}
	
	
	
	public static void main2(String[] args) {
		
		/*
		int a = 10;
		a = a++;
		System.out.println(a);//10??
		
		//Java 的反汇编   javap -c Test
		
		
		int a = 10;
		a += 1;//a = a+1;
		System.out.println(a);
		
		
		System.out.println(10.0%1.5);
		
		
		System.out.println(10%3);//1
		System.out.println(10%-3);//-1
		System.out.println(-10%3);//-1
		System.out.println(-10%-3);//1
		*/
	}
	
}
