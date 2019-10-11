


//输出 1000 - 2000 之间所有的闰年
//闰年：四年一闰、百年不闰、400年再闰

public class T4{
	public static void main(String[]args){
		int yearMax=2000;
		int year=1000;
		
		int i=4;		//四年一闰
		int j=100;		//百年不闰
		int k=400;		//400年再闰
		
		System.out.println("1000-2000（start-end）内的闰年有");
		
		while(year<=yearMax){
			if(year%4==0 && year%100!=0){		//能被4整除 且 不被100整除
				System.out.println(year);
			}
			else if(year%400==0){				//能被400整除
				System.out.println(year);
			}
	
		year++;		//逐个验证是否为闰年
		}
			
	}
}