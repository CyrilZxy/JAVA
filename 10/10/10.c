#define  _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>



////1
//int count_one_bits(unsigned int value)    //����1�ж���λ  
//{
//	int count = 0;
//	while (value)
//	{
//		// valueΪ0ʱ����ѭ��
//		if (value % 2 == 1)
//		{
//			//�������Ϊ1����count�Զ�+1
//			count++;
//		}
//		value = value / 2;
//		//���õ������ٸ���value
//	}
//	return count;
//}
//
//int main()
//{
//	int n = 0;
//	printf("������һ��������");
//	scanf("%d", &n);
//
//	int num = count_one_bits(n);		//numΪ��¼1�ĸ���
//	printf("num=%d\n", num);
//	system("pause");
//	return 0;
//}
//
//
//



//2  bug������
//int main()
//{
//	int value=0;
//	int a; 
//	printf("���������֣�");
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
	printf("������һ��������");
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
	printf("����������������Ϊ��%d \n", d);

	int e = 1;
	while (e<10)
	{
		e = a / d;
		a = a - e*d;
		d = d / 10;
		printf("������ÿһλ�Ӹߵ���Ϊ��%d \n", e);
	}
	printf("/n");
	//system("pause");
	return 0;
}