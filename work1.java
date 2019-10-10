

//交换两变量值 

public class work1
{
	public static void main(String[]args)
	{
		int num1 = 10;
		int num2 = 20;
		int sum=num1+num2;
		
		num1=sum-num1;
		num2=sum-num2;
		
		System.out.printf("num1=%d\n",num1);
		System.out.printf("num2=%d\n",num2);
	}
}