

//�궨��
#define uchar unsigned char 
#define uint unsigned int
#define ULint unsigned long int 
//�¶����������µı�־λ
char flag=0;
//������
char flags=0;
//����������
char flag1s=0;
//���㶨ʱ��
uint time=0;
//�������
ULint L_=0;
//�¶�
uint t_=0;
//��ʾģʽ  0����  1���ֵ����  2��Сֵ����
uchar mode=0;

uint Max=200;
uint Min=150;
//������־
uchar k=0;
//��ֵ����
uchar FW=0;
//ͷ����
#include <reg52.h>
#include <intrins.h>
#include "BJ_Key.h"	   	 //��������
#include "display.h"			 //��ʾͷ����
#include "ultrasonic_wave.h"//������ͷ����
#include "DS18B20.h"	   	 //�¶ȴ�����ͷ����


//��������
void delayms(uint ms);
//������
void main()
{
	Init_ultrasonic_wave();
	//��Ļ��ʼ��
	Init1602();
	//�¶ȳ�ʼ��
	tmpchange(); 
	t_=tmp();
	tmpchange();
	t_=tmp();
	tmpchange();
	t_=tmp();

	//ѭ����ʾ
	while(1)
	{
		Key();
		//������ʾ
		if(mode==0)
		{
			StartModule();//����������
			while(!RX);	  //��RXΪ��ʱ�ȴ�
			TR0=1;		  //��������
			while(RX);	  //��RXΪ1�������ȴ�
			TR0=0;		  //�رռ���
	
			delayms(20);  //20MS
			tmpchange();  //�¶�ת��
			t_=tmp();     //���¶�
			Conut(t_/10); //�������


			if(t_>=500){		//�¶ȴ�50������
				Stop();					 //ֹͣ
				Feng_Start();			 //����
			}

			if(t_<500 & L_>Min & L_<=Max){	  //��������
				Forward();		 	//ֱ��1010
			}  

			if(t_<500 & L_<=Min){	//�����С
				Feng_Start();		//����
				Turn_left();	 	//����0110
			}

			if(t_<500 & L_>Max){	//�������
				Turn_Retreat();		//����0101
			} 


			Display_1602(t_/10,L_);
		}
		//������ʾ
		else if(mode!=0)
		{
			//�����Сֵ
			Init_MaxMin();
			while(mode!=0)
			{
				
				Key();
				if(k==1&&mode==1)
				{
					Init_MaxMin();	
   				write_com(0x8d);//����λ��					
				}
				else if(k==1&&mode==2)
				{
					Init_MaxMin();	
   				write_com(0x8d+0x40);//����λ��	
				}
				k=0;
			}
			//�����ʼ��
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


//T0�ж��������������,������෶Χ
void CJ_T0() interrupt 1
{
    flags=1;							 //�ж������־
}



  //-----------------------------------


