

// 输出乘法口诀表


public class T5{
	public static void main(String[]args){
		int max=9;
		int i=1;
		
		while(i<=max){
	
			int j=1;		//初始j乘数 从1开始乘
			int ret=1;		//初始ret乘积
			
			while (j<=i){		//避免重复相乘
				ret=j*i;
				System.out.print(j+"*"+i+"="+ret+"  ");
				j++;
			}
			
			System.out.println("");		//换行 输出优化
			
		i++;
		}
		
	}
}