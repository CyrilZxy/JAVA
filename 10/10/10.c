#define  _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>



////1
//int count_one_bits(unsigned int value)    //计算1有多少位  
//{
//	int count = 0;
//	while (value)
//	{
//		// value为0时跳出循环
//		if (value % 2 == 1)
//		{
//			//如果余数为1，则count自动+1
//			count++;
//		}
//		value = value / 2;
//		//将得到的商再付给value
//	}
//	return count;
//}
//
//int main()
//{
//	int n = 0;
//	printf("请输入一个正数：");
//	scanf("%d", &n);
//
//	int num = count_one_bits(n);		//num为记录1的个数
//	printf("num=%d\n", num);
//	system("pause");
//	return 0;
//}
//
//
//



//2  bug。。。
//int main()
//{
//	int value=0;
//	int a; 
//	printf("请输入数字：");
//	scanf("%d",&value);
//
//		for(a=0; value % 2==1; a++)
//		{
//			value=value/2;
//		}
//		printf("%d",a);
//	system("pause");
//	return 0;
//	
//}











int main()
{
	int a;
	printf("请输入一个整数：");
	scanf("%d", &a);
	printf("\n");

	int b = 1;
	int c = 10;
	int d = 0;

	while (c>9)
	{
		c = a / b;
		b = b * 10;
	}
	d = b / 10;
	printf("该整数所在数量级为：%d \n", d);

	int e = 1;
	while (e<10)
	{
		e = a / d;
		a = a - e*d;
		d = d / 10;
		printf("该整数每一位从高到低为：%d \n", e);
	}
	printf("/n");
	//system("pause");
	return 0;
}