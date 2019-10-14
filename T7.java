 
 
 // 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
 
 public class T7{
	 public static void main(String[]args){
		
		double sum=0.0;
		
		for(double num=1;num<=100;num++){		//double类型 小数计算
			if(num%2==0){						//奇偶判断
				sum-=1/num;
			}else{
				sum+=1/num;
			}
		}
		
		System.out.println("sum="+sum);
	 }
 }