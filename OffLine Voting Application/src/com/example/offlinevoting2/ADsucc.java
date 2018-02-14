package com.example.offlinevoting2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class ADsucc extends Activity {
String entryarray[];
	TextView t1,t2,t3,t4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adsucc);
		t1=(TextView) findViewById(R.id.textView2);
		t2=(TextView) findViewById(R.id.textView4);

		t3=(TextView) findViewById(R.id.textView6);

		t4=(TextView) findViewById(R.id.textView8);
		
		
		
		try 
		{
			String s="";
			FileInputStream fin=openFileInput("Vote.txt");
			InputStreamReader isr=new InputStreamReader(fin);
			char[] inputBuffer =new char[100];
			int charRead;
			while((charRead =isr.read(inputBuffer))>0)
			{	
				//Toast.makeText(getBaseContext(),"Reading File",Toast.LENGTH_SHORT).show();
				String readString =String.copyValueOf(inputBuffer,0,charRead);
				s+=readString;
				inputBuffer =new char[100];
				//Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();	
			}
			if(s!=null)
			{
				entryarray=s.split(",");
			}
			else
			{
				Toast.makeText(getBaseContext(),"File Not Loaded",Toast.LENGTH_SHORT).show();
			}
			t1.setText(entryarray[0]);
			t2.setText(entryarray[1]);
			t3.setText(entryarray[2]);
			t4.setText(entryarray[3]);
			
		} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adsucc, menu);
		return true;
	}

}
