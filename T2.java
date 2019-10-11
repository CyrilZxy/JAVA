


//判定一个数字是否是素数 

public class T2{
	public static void main(String[] args){
		int num=11;
		int i=1;			//从1开始除到它本身
		int j=0;			//判定条件 能被多少个数字整除
		
		while(i<=num){
			
			if(num%i==0)
				j+=1;	
			else
				j+=0;	
			i++;
		}
		System.out.println("num="+num);
		
		if(j==2)			//大于两个不为素数
			System.out.println("数字num为素数,num只可被1和它本身整除。");
		else
			System.out.println("数字num不为素数,num可被整除的共数字有__个："+j);
		

		
	}
}
		
			
			