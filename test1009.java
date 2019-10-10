


//5！+4！+3！+2！+1！ 求和 阶乘

public class test1009
{
	public static void main(String []args )
	{
	int num=5;
	int i=1;
	int ret=1;
	int sum=0;
	
		while(i<=num){
			ret=1;				//初始化ret
			
			int j=1;			//阶乘运算 i的阶乘 初始化j
			while(j<=i){
				ret*=j;		//ret =ret *j;	
				j++;
			}
				
			i++;				//阶乘数++
			sum+=ret;			//sum=sum+ret;		
		}
		
		System.out.println("sum="+sum);
	
	}

}
