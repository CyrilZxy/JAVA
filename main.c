

//宏定义
#define uchar unsigned char 
#define uint unsigned int
#define ULint unsigned long int 
//温度零上与零下的标志位
char flag=0;
//超声波
char flags=0;
//超声波距离
char flag1s=0;
//计算定时间
uint time=0;
//计算距离
ULint L_=0;
//温度
uint t_=0;
//显示模式  0正常  1最大值调整  2最小值调整
uchar mode=0;

uint Max=200;
uint Min=150;
//按键标志
uchar k=0;
//数值有误
uchar FW=0;
//头函数
#include <reg52.h>
#include <intrins.h>
#include "BJ_Key.h"	   	 //报警按键
#include "display.h"			 //显示头函数
#include "ultrasonic_wave.h"//超声波头函数
#include "DS18B20.h"	   	 //温度传感器头函数


//函数声明
void delayms(uint ms);
//主函数
void main()
{
	Init_ultrasonic_wave();
	//屏幕初始化
	Init1602();
	//温度初始化
	tmpchange(); 
	t_=tmp();
	tmpchange();
	t_=tmp();
	tmpchange();
	t_=tmp();

	//循环显示
	while(1)
	{
		Key();
		//正常显示
		if(mode==0)
		{
			StartModule();//启动超声波
			while(!RX);	  //当RX为零时等待
			TR0=1;		  //开启计数
			while(RX);	  //当RX为1计数并等待
			TR0=0;		  //关闭计数
	
			delayms(20);  //20MS
			tmpchange();  //温度转换
			t_=tmp();     //度温度
			Conut(t_/10); //计算距离


			if(t_>=500){		//温度达50度以上
				Stop();					 //停止
				Feng_Start();			 //报警
			}

			if(t_<500 & L_>Min & L_<=Max){	  //距离适中
				Forward();		 	//直行1010
			}  

			if(t_<500 & L_<=Min){	//距离过小
				Feng_Start();		//报警
				Turn_left();	 	//避障0110
			}

			if(t_<500 & L_>Max){	//距离过大
				Turn_Retreat();		//后退0101
			} 


			Display_1602(t_/10,L_);
		}
		//调整显示
		else if(mode!=0)
		{
			//最大最小值
			Init_MaxMin();
			while(mode!=0)
			{
				
				Key();
				if(k==1&&mode==1)
				{
					Init_MaxMin();	
   				write_com(0x8d);//设置位置					
				}
				else if(k==1&&mode==2)
				{
					Init_MaxMin();	
   				write_com(0x8d+0x40);//设置位置	
				}
				k=0;
			}
			//界面初始化
			Init1602();
		}
	}
}

void delayms(uint ms)
{
	uchar i=100,j;
	for(;ms;ms--)
	{
		while(--i)
		{
			j=10;
			while(--j);
		}
	}
}


//T0中断用来计数器溢出,超过测距范围
void CJ_T0() interrupt 1
{
    flags=1;							 //中断溢出标志
}



  //-----------------------------------


