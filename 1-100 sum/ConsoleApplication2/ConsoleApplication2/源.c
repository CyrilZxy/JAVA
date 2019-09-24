#include<stdio.h>
#define M 100

int Sum(int top)
{
	int sum = 0;
	int i = 1;
	for (; i <= top;i++)
	{
		sum += i;
	}
	return sum;
}

int main()
{
	printf("cal bedin...\n");

	int result = Sum(100);		//M
	printf("cal end...\n");
	printf("result:%d\n", result);
	return 0;
}