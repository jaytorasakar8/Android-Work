package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends Activity {

	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

	public void click(View v)
	{
		//tv=(TextView)findViewById(R.id.tv1);
		
		/*           //////////////Instead this whole code in the switch case. it would then sort out acc to our needs
		String tagValue = (String) v.getTag();
		int i=v.getId();
		/*String arrayname="R.array.array"+i;
		int arr=Integer.parseInt(arrayname);*/
		
		/*String arrayname="R.array.array"+tagValue;
		int arr=Integer.parseInt(arrayname);*/
		/*
		String[] a = getResources().getStringArray(R.array.array0);
		//Toast.makeText(getBaseContext(), "u clicked on a row1", Toast.LENGTH_LONG).show();
		tv.setText("\n"+a[0]+"\n"+a[1]+"\n"+a[2]+"\n"+a[3]+"\n"+tagValue);
		*/
		switch(v.getId())
		{
		case R.id.tr0: Toast.makeText(getBaseContext(), "u clicked on a row1", Toast.LENGTH_LONG).show();break;
		case R.id.tr1: Toast.makeText(getBaseContext(), "u clicked on a row1", Toast.LENGTH_LONG).show();break;
		}
	}
}
