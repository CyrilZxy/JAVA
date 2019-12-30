
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
//导入包  

/**
1、break:结束所有循环
2、continue：结束本次循环
3、当for循环的第二个表达式没有的时候
他就是一个死循环。
4、for(int i = 100;i = 1;i++) {} 错误的的写法

5、System.in  键盘
   System.out
   
6、Scanner：工具类   引入包    import
   new；
   
   Scanner scan = new Scanner(System.in);
   
   scan.方法
   
   
7、每日一题、链接;  摄像头 麦克风  
   选择题   代码题
   笔试：
8、
    public static 方法的返回值  方法名 (形参列表) {
		
		方法体；
		
	} 
	add:方法名：小写  addTowNum();
	
	声明：Java方法不需要声明
	
	参数要一一对应
9、方法的重载（overload）
   函数名相同
   参数不同(类型 或者参数个数 )
   返回值不做要求
   
   必须在同一个类中 或者 是在继承前提下
   
   面试题：
   同学 讲一下下：重载和重写的区别？？？
10、
   递归：
     1、调用自己本身
	 2、有一个趋近于终止的条件

函数的调用：发生在栈上的。栈是有大小的。1M/2M

栈溢出之后：
Exception in thread "main" 
        java.lang.StackOverflowError
		
		
递归的本质：
    将大事 化小事的过程  将大问题化解为小问题的过程
	

N!   5!->5*4!-> 5*4*3!。。。。。。

递归的思考：
不要尝试在自己的脑海当中 展开递归的代码！！！

  横向思考    
  代码纵向执行
  
*/

public class Test {
	
	
	public static void fun() {
		fun();
	}
	
	public static int fac2(int n) {
		if(n == 1) {
			return 1;
		}
		return n * fac2(n-1);
	}
	
	public static void main(String[] args) {
		//fun();
		int a = fac2(5);
		System.out.println("a:" + a);
	}
	
	
	
	public static int add(int a,int b) {
		return a+b;
	}
	public static int add(int a,int b,int c) {
		return a+b+c;
	}
	public static double add(double a,double b) {
		return a+b;
	}
	
	
	
	
	public static void main6(String[] args) {
		
		int a = 10;
		int b = 20;
		int bb = 30;
		int ret = add(a,b);
		System.out.println("ret:" + ret);
		
		
		ret = add(a,b,bb);
		System.out.println("ret:" + ret);
		
		double c = 12.5;
		double d = 10.5;
		double ret2 = add(c,d);
		System.out.println("ret2:" + ret2);
		
	}
	
	//模块化
	
	public static int fac(int num) {
		int ret = 1;
		for(int i = 1;i <= num;i++) {
			ret *=i;
		}
		return ret;
	}
	
	public static void swap1(int a,int b) {
		int tmp = a;
		a = b;
		b = a;
	}
	//C:按值传递  按址传递     Java：按值传递
	
	public static void swap2(int[] array) {
		int tmp = array[0];
		array[0] = array[1];
		array[1] = tmp;
	}
	
	public static int[] swap(int[] array) {
		int tmp = array[0];
		array[0] = array[1];
		array[1] = tmp;
		return array;
	}
	
	public static void main5(String[] args) {
		
		int[] array = {10,20};
		System.out.println("x = "+ array[0]);
		System.out.println("y = "+ array[1]);
		int[] array2 = swap(array);
		System.out.println("x2 = "+ array2[0]);
		System.out.println("y2 = "+ array2[1]);
		/*
		int x = 10;
		int y = 20;
		swap(x,y);
		System.out.println("x = "+ x);
		System.out.println("y = "+ y);
		*/
	
	}
	
	
	public static void main4(String[] args) {
		//1!+2!+3!+4!+5!
		int num = 5;
		int sum = 0;
		for(int i = 1;i <= num;i++) {
			sum += fac(i);
		}
		System.out.println("sum = "+ sum);
	}
	
		
	
	/*
	public static int add(int a,int b) {
		System.out.println("调用函数中：");
		int ret = a+b;
		return ret;
		//return a+b;
	}
	
	
	public static void add(int a,int b) {
		int ret = a+b;
		System.out.println("ret:"+ret);
	}*/
	
	public static void main3(String[] args) {
		System.out.println("调用函数之前：");
		int ret = add(10,20);
		System.out.println("调用函数结束：");
		System.out.println("ret:"+ret);
		
		System.out.println("第二次调用方法之前");
		ret = add(30, 50);
		System.out.println("第二次调用方法之后");
		System.out.println("ret = " + ret);
	}
	
	
	
	
	public static void main2(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//Random产生随机数的类
		Random rand = new Random();// 对象
		
		int randNum = rand.nextInt(100)+1;
		//[0,100)+1// [1-100]
		
		while(true) {
			System.out.println("输入你要猜的数字：");
			int num = scan.nextInt();
			
			if(num > randNum) {
				System.out.println("大了");
			}else if (num == randNum) {
				System.out.println("猜对了");
				break;
			}else {
				System.out.println("小了");
			}
		}
		scan.close();
	}
	
	
	
	public static void main1(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		int num = 0;
		
		while(scan.hasNextInt()) {
			num = scan.nextInt();
			System.out.println(num);
		}
		
		scan.close();
		
		/*
		System.out.println("输入学生的姓名：");
		
		String name = scan.nextLine();
		
		System.out.println("name = "+ name);
		
		System.out.println("输入学生的年龄：");
		
		int age = scan.nextInt();
		System.out.println("age = "+ age);
		
		System.out.println("输入学生的身高(cm)：");
		
		double high = scan.nextDouble();
		System.out.println("high = " + high);
		
		scan.close();
		
		
		
		try {
			System.out.print("Enter a Char:");
			char i = (char) System.in.read();
			System.out.println("your char is :"+i);
		}catch(IOException e) {
			
		}
		
		
		
		
		int x = 10;
		System.out.printf("%d", x);
		
		
		
		int i = 0;
		//do{
			//System.out.println("i = "+ i);
		//}while(i!=0);
		
		while(i!=0) {
			System.out.println("i = "+ i);
		}
		
		
		
		//1!+2!+3!+4!+5!
		
		int num = 5;
		int ret = 1;
		int sum = 0;
		
		
		for(int i = 1;i <= num;i++) {
			ret = 1;
			for(int j = 1;j <= i;j++) {
				ret *= j;
			}
			sum += ret; 
		}
		
		System.out.println("sum = "+ sum);
		
		
		//分别计算奇数的和  偶数的和  1-100
		int sumOdd = 0;//奇数和
		
		int sumEve = 0;//偶数和
		
		int i = 0;
		for(i = 1; i <= 100;i += 2) {
			sumOdd += i;
		}
		
		for(i = 2; i <= 100;i += 2) {
			sumEve += i;
		}
		System.out.println("sumOdd = "+ sumOdd);
		System.out.println("sumEve = "+ sumEve);
		
		
		
		for(int i = 100;i< = 200;i++) {
			if(i % 3 != 0) {
				continue;
			}
			System.out.println("i = "+ i);
		}
		
		
		
		for(int i = 100;i <= 200;i++) {
			if(i % 3 != 0) {
				continue;
			}
			System.out.println("i = "+ i);
		}
		
		for(int i = 100;i <= 200;i++) {
			if(i % 3 == 0) {
				System.out.println("i = "+ i);
				break;
				System.out.println("hello");
			}
			System.out.println("hello");
		}
		*/
	}
}