public class test1008
{
	public static void main(String []args)
	{
		char ch1='A';
		char ch2='啊';
		System.out.println(ch1);
		System.out.println(ch2);
		
		byte value1=0;
		System.out.println(value1);
		
		short value2=10;
		System.out.println(value2);
		
		boolean value3=true;
		System.out.println(value3);
		//System.out.println(value3+1);	 error 布尔只有真假
		
		String name1="zxy";
		System.out.println(name1);
		String name2="My name is \"zxy\"";	//转义字符
		
		String a="hello";			// + 字符串拼接
		String b="world";
		String c=a+b;
		System.out.println(c);
		
		String str="result = ";		//字符串与数字拼接
		int x=10;
		int y=20;
		String result=str+x+y;
		System.out.println(result);
		
		int n=10;					//有字符串按字符加 不计算
		int m=20;
		System.out.println("n="+n+",m="+m);
		
	}
}