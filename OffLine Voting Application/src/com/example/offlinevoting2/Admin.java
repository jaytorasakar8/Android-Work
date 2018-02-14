package com.example.offlinevoting2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Admin extends Activity {
Button Ab2,Ab1;
EditText e1,e2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		Ab2=(Button) findViewById(R.id.ADbutton2);
		Ab1=(Button) findViewById(R.id.ADbutton1);
		e1=(EditText) findViewById(R.id.ADeditText1);
		e2=(EditText) findViewById(R.id.ADeditText2);
		Ab1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if((e1.getText().toString()).equals("admin") && (e2.getText().toString()).equals("admin123")){
					Intent i=new Intent(getBaseContext(),ADsucc.class);
					startActivity(i);
				}
				// TODO Auto-generated method stub
				
				
			}
		});
		Ab2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent j=new Intent(getBaseContext(),MainActivity.class);
				startActivity(j);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin, menu);
		return true;
	}

}
