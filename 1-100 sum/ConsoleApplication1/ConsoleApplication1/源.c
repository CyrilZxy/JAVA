#include<stdio.h>

int main()
{
	int num;
	int sum=0;
	for (num = 1; num < 101; num++)
	{
		sum = sum + num;
	}
	printf("sum=%d \n",sum);

	return 0;
}