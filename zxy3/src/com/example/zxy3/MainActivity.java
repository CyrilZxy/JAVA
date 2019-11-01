package com.example.zxy3;


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
	private TextView lable;
	private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lable=(TextView)findViewById(R.id.lable);
        edit=(EditText)findViewById(R.id.edit);
        ok=(Button)findViewById(R.id.ok);

        }
    
    
 }
