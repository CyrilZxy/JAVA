


//求出0～999之间的所有“水仙花数”并输出。
//(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本 

public class T9{
	public static void main(String[]args){
		
		for(int num=0;num<=999;num++){			
		
		int a,b,c,sum=0;
			a=num/100;				//百位
			b=(num%100)/10;			//十位
			c=num%10;				//个位
			sum=a*a*a+b*b*b+c*c*c;
				
			if(sum==num){
				System.out.println(num);
			}
		}		
		
	}
}
	