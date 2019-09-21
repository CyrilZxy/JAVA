#include <stdio.h>

int main()
{
	
	int num1;
	int num2;
	int sum = 0;
	for (num1=1;num1 < 10;num1++)
	{
		
		for (num2 = 1; num2 < 10; num2++)
			{
				sum = num1*num2;
				printf("sum=%d*%d=%d\n",num1,num2,sum);
			}

		printf("\n");

	}
	
	   return 0;
}
