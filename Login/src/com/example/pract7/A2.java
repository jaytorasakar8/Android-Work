package com.example.pract7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class A2 extends Activity {

	TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a2);
		
		tv1=(TextView) findViewById(R.id.tv1);
		
		Bundle b2= getIntent().getExtras();
		String s1=b2.getString("username");
		String s2=b2.getString("password");
		
		
		if(s1.equals("ad")&& s2.equals("pq"))
		{
			tv1.setText("Welcome"+s1);
		}
		else
		{
			Toast.makeText(getBaseContext(), "Error",Toast.LENGTH_LONG).show();
		}
		
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.a2, menu);
		return true;
	}

}
