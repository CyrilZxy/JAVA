package com.example.zxy;

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

import android.graphics.*;
import android.widget.*;


public class MainActivity extends Activity {
	
	private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txt=(TextView)findViewById(R.id.textView1);

    }
}




//tools:context="com.example.zxy.MainActivity"
