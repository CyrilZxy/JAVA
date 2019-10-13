


//猜数字游戏 
//系统给一个随机数（1-100），然后猜 给出提示高了 低了

	import java.util.Random;			//生成随机数 Random包
	import java.util.Scanner;			//录入数据 Scanner包
										//包
public class T14{
	public static void main(String[]args){
		
	Scanner sc = new Scanner(System.in); 	//录入键盘数据
	
	Random random = new Random(); 			// 默认随机种子是系统时间
	int toGuess = random.nextInt(100); 		//random 
	
	while (true) { 
		System.out.println("请输入要输入的数字: (1-100)"); 
		int num = sc.nextInt(); 
		if (num < toGuess) { 
		System.out.println("低了"); 
		} else if (num > toGuess) { 
		
		System.out.println("高了"); 
		} else { 
		System.out.println("猜对了"); 
		break;
		}
	}		
	sc.close();			//关闭调用
	
	}
}