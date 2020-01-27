package com.example.dn.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceHolder.Callback;
import android.view.ViewGroup;
import android.content.Context;
import android.content.pm.*;
import android.graphics.*;
import android.hardware.*;
import android.view.*;


public class MainActivity extends AppCompatActivity {




        BallView mAnimView=null;

        @Override
        protected  void  onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            mAnimView=new  BallView(this);
            setContentView(mAnimView);
        }
        public  class BallView  extends  SurfaceView implements
                Callback,Runnable,SensorEventListener{
            public  static  final  int  TIME_IN_FRAME=50;
            Paint mPaint=null;
            Paint mTextPaint=null;
            SurfaceHolder mSurfaceHolder=null;
            boolean  mRunning=false;
            Canvas mCanvas=null;
            boolean  mIsRunning=false;
            private  SensorManager mSensorMgr=null;
            Sensor mSensor=null;
            int  mScreenWidth=0;
            int  mScreenHeight=0;
            private  int  mScreenBallWidth=0;
            private  int  mScreenBallHeight=0;
            private  Bitmap mbitmapBg;
            private  Bitmap mbitmapBall;
            private  float  mPosX=200;
            private  float  mPosY=0;
            private  float  mGX=0;
            private  float  mGY=0;
            private  float  mGZ=0;
            public  BallView(Context context){
                super(context);
                this.setFocusable(true);
                this.setFocusableInTouchMode(true);
                mSurfaceHolder=this.getHolder();
                mSurfaceHolder.addCallback(this);
                mCanvas=new  Canvas();
                mPaint=new  Paint();
                mPaint.setColor(Color.WHITE);
                mbitmapBall=BitmapFactory.decodeResource(this.getResources(),R.drawable.ball);
                mbitmapBg=BitmapFactory.decodeResource(this.getResources(),R.drawable.bg);
                mSensorMgr=(SensorManager)getSystemService(SENSOR_SERVICE);
                mSensor=mSensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                mSensorMgr.registerListener(this,mSensor,SensorManager.SENSOR_DELAY_GAME);}
            private  void  Draw(){
                Rect src=new  Rect(0,0,mbitmapBg.getWidth(),mbitmapBg.getHeight());
                Rect dst=new  Rect(0,0,this.getWidth(),this.getHeight());
                mCanvas.drawBitmap(mbitmapBg, src, dst, mPaint);
                mCanvas.drawBitmap(mbitmapBall,mPosX,mPosY,mPaint);
                mCanvas.drawText("X轴重力值："+mGX, 0, 20, mPaint);
                mCanvas.drawText("Y轴重力值："+mGY, 0, 40, mPaint);
                mCanvas.drawText("Z轴重力值："+mGZ, 0, 20, mPaint);
            }
            public void surfaceChanged(SurfaceHolder holder,int format,int width,int height){}
            public void surfaceCreated(SurfaceHolder holder)
            {mIsRunning=true;
                new Thread(this).start();
                mScreenWidth=this.getWidth();
                mScreenHeight=this.getHeight();
                mScreenBallWidth=mScreenWidth-mbitmapBall.getWidth();
                mScreenBallHeight=mScreenHeight-mbitmapBall.getHeight();
            }
            public void surfaceDestroyed(SurfaceHolder holder)
            {
                mIsRunning=false;
            }
            public void run()
            {
                while(mIsRunning)
                {
                    long startTime=System.currentTimeMillis();
                    synchronized(mSurfaceHolder)
                    {
                        mCanvas=mSurfaceHolder.lockCanvas();
                        Draw();
                        mSurfaceHolder.unlockCanvasAndPost(mCanvas);
                    }
                    long endTime=System.currentTimeMillis();
                    int diffTime=(int)(endTime-startTime);
                    while(diffTime<=TIME_IN_FRAME)
                    {
                        diffTime=(int)(System.currentTimeMillis()-startTime);
                        Thread.yield();
                    }
                }
            }
            public void onAccuracyChanged(Sensor arg0,int arg1)
            {

            }
            public void onSensorChanged(SensorEvent event)
            {
                mGX=event.values[0];
                mGY=event.values[1];
                mGZ=event.values[2];
                mPosX+=mGX*2;
                mPosY+=mGY*2;
                if(mPosX<0)
                {
                    mPosX=0;
                }
                else if(mPosX>mScreenBallWidth)
                {
                    mPosX=mScreenBallWidth;
                }
                if(mPosY<0)
                {
                    mPosY=0;
                }
                else if(mPosY>mScreenBallHeight)
                {
                    mPosY=mScreenBallHeight;

                }
            }
        }
}


