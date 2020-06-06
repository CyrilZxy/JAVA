
	#include <reg51.h>
    #include <stdio.h>
    #include <intrins.h>

#define  TX  P1_3
#define  RX  P1_2
#define Forward_L_DATA  180 //当前进不能走直线时，调节这两个参数，理想是100，100，最大时256，最小是0.
#define Forward_R_DATA  180
sbit L293D_IN1=P0^0; 
sbit L293D_IN2=P0^1;
sbit L293D_IN3=P0^2;
sbit L293D_IN4=P0^3;
sbit L293D_EN1=P0^4;
sbit L293D_EN2=P0^5;

sbit p0_6 = P0^6;
sbit p1_7 = P1^7;

sbit p2_0 = P2^0;
sbit p3_3 = P3^3; 

sbit RX = P1^2; 
sbit TX = P1^3; 




void Delay400Ms(void);//延时400毫秒函数
unsigned char disbuff[4]={0,0,0,0};//用于分别存放距离的值0.1mm,mm,cm,m
void Count(void);//距离计算函数
unsigned int  time=0;//用于存放定时器的时间值
unsigned long S=0;//用于存放距离的值
bit  flag =0;//量程溢出标志位
bit  turn_right_flag;
void Delay1ms(unsigned int i) 
{ 
unsigned char j,k; 
do{ 
  j = 10; 
  do{ 
   k = 50; 
   do{ 
    _nop_(); 
   }while(--k);     
  }while(--j); 
}while(--i); 
} 
void Delay10us(unsigned char i) 
{ 
   unsigned char j; 
do{ 
  j = 10; 
  do{ 
   _nop_(); 
   }while(--j); 
}while(--i); 
}
void Forward()//前进
{
  L293D_IN1=1; 
  L293D_IN2=0;
  L293D_IN3=1;
  L293D_IN4=0;
}
void Stop(void)//刹车
{
  L293D_IN1=0; 
  L293D_IN2=0;
  L293D_IN3=0;
  L293D_IN4=0;
}
void Turn_Retreat()//后
{
 L293D_IN1=0; 
 L293D_IN2=1;
 L293D_IN3=0;
 L293D_IN4=1;
}
void Turn_left()//左
{
 L293D_IN1=0; 
 L293D_IN2=1;
 L293D_IN3=1;
 L293D_IN4=0;
}
void Conut(void)//计算距离
 {
  time=TH1*256+TL1;
  TH1=0;
  TL1=0;
  S=time*2;
  S=S*0.17;
  if(S<=300)
  {
  if(turn_right_flag!=1)
  {
      Stop();
      Delay1ms(5);
  }
  turn_right_flag=1;
  	p1_7=0;
 	p2_0=0;
 	p0_6=0;
		 Delay1ms(10);
	    p1_7=1;
 	    p2_0=1;
 	   	p0_6=1;
  Delay1ms(5);
  Turn_left();
  Delay1ms(10);
 }
 else
 {
 turn_right_flag=0;
 Forward();
 }
 if((S>=5000)||flag==1)//超出测量范围
 {
 flag=0;
 }
 else
  {
   disbuff[0]=S%10;
   disbuff[1]=S/10%10;
   disbuff[2]=S/100%10;
   disbuff[3]=S/1000;
  }
 }
 void zd0() interrupt 3//T0中断用来计数器溢出，超过测距范围
 {
 	flag=1;
 	RX=0;
 }

 void Timer_Count(void)
 {
	 TR1=1;//开启计数
 	while(RX);//当RX为1计数并等待
 	TR1=0;//关闭计数
 	Conut();//计算
 }

 void  StartModule()//启动模块
 {
 	TX=1;//启动一次模块
 	Delay10us(2);
 	TX=0;
 }

 void main(void)
 {
 unsigned char i;
 unsigned int a;
 Delay1ms(400);
 Delay1ms(5);
 TMOD=TMOD|0x10;
    EA=1;
    TH1=0;
    TL1=0;          
    ET1=1;
    turn_right_flag=0;
 B:  for(i=0;i<50;i++)//判断k3是否按下
 {
 Delay1ms(1);
 if(p3_3!=0 )
 goto B;
 }
while(1)
   {
  RX=1;
     StartModule();
        for(a=951;a>0;a--)
     {
     
        if(RX==1)
     {
           Timer_Count();
     }
      }
    }
}