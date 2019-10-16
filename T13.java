

// 输出一个整数的每一位. 

public class T13{
	public static void main(String[]args){
		
		int num=7545668;
		func(num);
		
	}
	
	public static void func (int num){				//方法调用
		
		if(num>9){
			func(num/10);
			System.out.println(num%10);
		}
		else System.out.println(num); 
	
	}
		
}