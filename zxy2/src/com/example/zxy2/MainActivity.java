package com.example.zxy2;

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

import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private EditText edit;
	private TextView txt1;
	private TextView txt2;
	private Button mButton01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=(TextView)findViewById(R.id.myTextView01);
        txt2=(TextView)findViewById(R.id.myTextView02);
        edit=(EditText)findViewById(R.id.myEditText);
        mButton01=(Button)findViewById(R.id.myButton);
        mButton01.setOnClickListener(new mClick());
    }

class mClick implements OnClickListener{
    	public void onClick(View v)
    	{
    		String passwd;
    		passwd=edit.getText().toString();
    		if(passwd.equals("abc123"))
    			txt2.setText("欢迎进入快乐大本营！");
    		else
    			txt2.setText("非法用户，请立即离开！");	
    	}
}



}
