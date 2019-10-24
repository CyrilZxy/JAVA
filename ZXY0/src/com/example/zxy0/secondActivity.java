package com.example.zxy0;

import android.app.Activity; 
import android.app.ActionBar;
import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zxy0.MainActivity.btnclock;

public class secondActivity extends Activity {

	Button btn2;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        
        TextView txt2=(TextView)findViewById(R.id.textView2);
        Bundle bundle=this.getIntent().getExtras();
        String str=bundle.getString("text");
        txt2.setText(str);

        btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new btnclock2());
    }


    class btnclock2 implements OnClickListener{
    	public void onClick(View v){
    		Intent intent2=new Intent();
    		intent2.setClass(secondActivity.this,secondActivity.class);
    		startActivityForResult(intent2,0);
    		
    	}
    }
}