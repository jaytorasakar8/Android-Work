package com.example.myapp;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class Test2 extends Activity {

	TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test2);
		
		tv1=(TextView)findViewById(R.id.tv1);
		try{
			 FileInputStream fin=openFileInput("mydata");
	         InputStreamReader isr=new InputStreamReader(fin);
	         char[] inputbuffer =new char[100];
	         int charRead;
	         String s="";
	         
	         while((charRead=isr.read(inputbuffer))>0)
	         {
	         	String readstring=String.copyValueOf(inputbuffer,0,charRead);
	         	s=s+readstring;
	         	inputbuffer=new char[100];
	         }
	        tv1.setText(s);
			}
			catch(Exception e){
				System.out.print(e.getMessage());
			}
	        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test2, menu);
		return true;
	}

}
