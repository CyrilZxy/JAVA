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

public class MainActivity extends Activity {
	
	Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(new btnclock());
    }


    class btnclock implements OnClickListener{
    	public void onClick(View v){
    		Intent intent=new Intent();
    		intent.setClass(MainActivity.this,secondActivity.class);
    		EditText txt=(EditText)findViewById(R.id.editText1);
    		Bundle bundle=new Bundle();
    		bundle.putString("text",txt.getText().toString());
    		intent.putExtras(bundle);
    		startActivity(intent);
    		
    	}
    }
}

    
    
    
    
    
 