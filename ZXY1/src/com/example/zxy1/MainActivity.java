package com.example.zxy1;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.PendingIntent;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {
	
	
	private IntentFilter receiveFilter;

	private static final String action="android.provider.Telephony.SMS_RECEIVED";
	private Button btnMain,btnDial,btnSMS;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		System.out.println("Activity1:onCreat()");
		
		btnMain=(Button)findViewById(R.id.btnMain);
		btnDial=(Button)findViewById(R.id.btnDial);
		btnSMS=(Button)findViewById(R.id.btnSMS);
		
		
		btnMain.setOnClickListener(new View.OnClickListener(){
			public void onClick(View arg0){
				//TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setAction(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				startActivity(intent);
			}
		});
		
		
		btnDial.setOnClickListener(new View.OnClickListener(){
			public void onClick(View arg0){
				//TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setAction(Intent.ACTION_DIAL);
				intent.addCategory(Intent.CATEGORY_DEFAULT);
				startActivity(intent);
			}
		});
		
		
		btnSMS.setOnClickListener(new View.OnClickListener(){
			public void onClick(View arg0){
				//TODO Auto-generated method stub
				Intent intent=new Intent(Intent.ACTION_SENDTO);
				intent.setData(Uri.parse("smsto:13679129896"));
				intent.putExtra("sms body","通过android应用发送的短消息");
				startActivity(intent);
			}
		});
				

	}

}