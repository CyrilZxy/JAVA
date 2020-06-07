	#include <reg51.h>
    #include <stdio.h>
    #include <intrins.h>
#define uchar unsigned char
#define uint unsigned int
      
sbit DQ=P1^5;
sbit led=P1^0;


sbit rs=P3^0;
sbit rw=P3^1;
sbit e=P3^2;
uchar temp,temp1;

void delay(uint t);
void delay_1ms(uint z);
uchar init_ds18b20();
void write_byte(uchar dat);
uchar read_byte(void);
uchar read_tem(void);

void write_com(uchar com);
void write_dat(uchar dat);
void init();

void main()
{  uchar n;
     init();
    while(1)
    {
     temp=read_tem();      //温度值的整数部分
   n=init_ds18b20();
    if(n)
      led=0;

   write_com(0x80+8);
   write_dat(0xdf);    //显示温度符号
   write_dat(0x43);     //显示温度符号

   delay_1ms(5);
  
   write_com(0x80+4);
   write_dat(0x30+temp/10);     //显示温度的十位

   write_dat(0x30+temp);     //显示温度的个位

   write_com(0x80+6);
   write_dat('.');
   write_dat(0x30+temp1);      //显示小数部分
  
     
     }
}
void delay_1ms(uint z) //

{
    uint x,y;
    for(x=z;x>0;x--)
        for(y=110;y>0;y--);
}
void delay(uint t)
{
     while(t--);
}
uchar init_ds18b20()
{
     uchar n;
     DQ=1;
     delay(8);
     DQ=0;
     delay(80);//600us
     DQ=1;
     delay(8);//15us~60us
     n=DQ;
     delay(4);

  return 0;
}
void write_byte(uchar dat)
{
   
    uchar i;
    for(i=0;i<8;i++)
    {
       DQ=0;
       DQ=dat&0x01;
       delay(4);
       DQ=1;
       dat=dat>>1;

    }
    delay(4);
}
uchar read_byte(void)
{
   uchar i,value;
   for(i=0;i<8;i++)
   {
       DQ=0;
       value>>=1;
       DQ=1; //

       if(DQ)
         value|=0x80;
       delay(4);
        
  
   }
   return value;
}
uchar read_tem(void)
{
    uchar a,b,temp0;   

    init_ds18b20();
    write_byte(0xcc);//ì?1yROM
    write_byte(0x44);//???ˉ???è2aá?
    delay(300);
   
    init_ds18b20();
    write_byte(0xcc);
    write_byte(0xbe);//?á???è

    a=read_byte();
    b=read_byte();
  
    b<<=4;
 temp1=(a&0x0f);
 temp1=temp1*0.625+0.5;
    a>>=4;
    temp0=b|a;
 
    return temp0;
}
void write_com(uchar com)
{
   rs=0;//????D′??á?
   rw=0;
   P2=com;
   e=1;
   delay_1ms(5);//?T?óê±2??ü?y3￡1¤×÷
   e=0;
}
void write_dat(uchar dat)
{
   rs=1;//????D′êy?Y
   rw=0;
   P2=dat;
   e=1;
   delay_1ms(5);// 

   e=0;
}
void init()  //

{
   delay_1ms(15);
   write_com(0x38);
   delay_1ms(6);
   write_com(0x38);
   delay_1ms(6);
   write_com(0x38);
   write_com(0x38);
   write_com(0x0c); 
   write_com(0x06);
   write_com(0x01);
  
}