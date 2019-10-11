



//打印 1 - 100 之间所有的素数
//素数只能被1和本身整除

public class T3{
	public static void main(String[]args){
		int nums=100;
		int num=1;
		
		System.out.println("1-100（num-nums）内的素数有");
		
		while(num<=nums){
			
			int i=1;		//初始化i 从1开始除			局部变量
			int j=0;		//初始化j 能被j个数整除		局部变量
			
			while(i<=num){
				
			
				if(num%i==0)		//取余为0，则为整除 整除j+1
					j+=1;	
				else
					j+=0;	
				i++;
			}
			
									//只能被两个数整除，为素数 输出
			if (j==2){						
				System.out.println(num);
			}else ;
			
			

			//System.out.println("num="+num+"，可被整除的数有_个"+j);
			//if(j==2)			//大于两个不为素数
			//System.out.println("数字num为素数");
			//else
			//System.out.println("数字num不为素数");
		
		
		num++;		//逐个验证是否为素数
		}
	}
}
		