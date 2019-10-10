



//给定三变量值 求最大最小值
public class work2
{
	public static void main (String []args)
	{
		int num1=86;
		int num2=79;
		int num3=95;
		int max=0;
		int min=0;
		
		if(num1>num2)
		{
			max=num1;
			if(num2>num3){
			min=num3;}
			else min=num2;
		}
		else 
		{
			max=num2;
			if(num1>num3){
			min=num3;}
			else min=num1;
		}
		
		if(max>num3)
		{
			;
		}
		else 
		{
			max=num3;
			if(num1>num2){
			min=num2;}
			else min=num1;
		}
		
		System.out.println("max="+max);
		System.out.println("min="+min);
		
		
	}
}