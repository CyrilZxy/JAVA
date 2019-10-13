	
	
import java.util.Random;
import java.util.Scanner;

public class bao{
	public static void main(String[]args){
	
	Scanner sc=new Scanner(System.in);
	
	/*    循环读取数字 输出和 平均值
	int num=0;
	double sum=0.0;
	while(sc.hasNextDouble()){
		double tmp=sc.nextDouble();
		sum+=tmp;
		num++;
	}
	System.out.println("sum="+sum);
	System.out.println("avg="+sum/num);
	*/
	
	//sc.nextInt()   把录入 输出
	System.out.println("输入一个身高值");		
	int high =sc.nextInt();
	System.out.println("high="+high);
	
	
	sc.close();
	
	}
}