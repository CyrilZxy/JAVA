



// 编写程序数一下 1到 100 的所有整数中出现多少个数字9。

public class T8{
	public static void main(String[]args){
	
		int num=100;
		int out=0;
		
		for(int i=1;i<=100;i++){
			
			if (i%10==9||i/10==9){			// 逻辑或  十位九 /10=9  个位九%10=9
				out+=1;
				System.out.println(i);		//输出含九数字
			}
		}
		System.out.println("含9的数字有："+out);
	}
}