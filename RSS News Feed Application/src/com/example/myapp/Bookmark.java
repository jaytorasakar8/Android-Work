package com.example.myapp;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class Bookmark extends Activity {

	Button bt1;
	RadioGroup rg1;
	static Integer choice;
	private String file = "mydata";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bookmark);
		
		bt1=(Button)findViewById(R.id.bt1);
		rg1=(RadioGroup)findViewById(R.id.rg1);
		
		rg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
			
				RadioButton rb1=(RadioButton)findViewById(R.id.rb1);
				RadioButton rb2=(RadioButton)findViewById(R.id.rb2);
				RadioButton rb3=(RadioButton)findViewById(R.id.rb3);
				RadioButton rb4=(RadioButton)findViewById(R.id.rb4);
				
				if(rb1.isChecked())
				{
					choice=1;
					Toast.makeText(getBaseContext(), "choice 1"+ "\n"+"The choice we made is:"+ choice, Toast.LENGTH_LONG).show();
				}
				
				if(rb2.isChecked())
				{
					choice=2;
					Toast.makeText(getBaseContext(), "choice 2"+ "\n"+"The choice we made is:"+ choice, Toast.LENGTH_LONG).show();
				}
				if(rb3.isChecked())
				{
					choice=3;
					Toast.makeText(getBaseContext(), "choice 3"+ "\n"+"The choice we made is:"+ choice, Toast.LENGTH_LONG).show();
				}
				if(rb4.isChecked())
				{
					choice=4;
					Toast.makeText(getBaseContext(), "choice 4"+ "\n"+"The choice we made is:"+ choice, Toast.LENGTH_LONG).show();
				}
				
			}
		});
		
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Toast.makeText(getBaseContext(),"The choice we made is:"+ choice, Toast.LENGTH_LONG).show();
				
				try{
					String s=""+choice;
			         FileOutputStream out=openFileOutput(file,MODE_WORLD_READABLE);
			         OutputStreamWriter fout=new OutputStreamWriter(out);
			         fout.append(s);
			         fout.flush();
			         fout.close();
			         Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
			        // ed1.setText("");
					
				}catch(Exception e){}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bookmark, menu);
		return true;
	}
	
	public boolean  onOptionsItemSelected(MenuItem mi)
    {
    	switch (mi.getItemId()) {
		case R.id.homepage:
			Intent i1=new Intent(Bookmark.this, HomePage.class);
			startActivity(i1);
			return true;

		case R.id.bookmark:
			Intent i2=new Intent(Bookmark.this, Bookmark.class);
			startActivity(i2);
			return true;

		case R.id.exit:
			Intent i3=new Intent(Bookmark.this, Test.class);
			startActivity(i3);
			return true;

    	}
		return false;
    	
    }



}
