package com.example.resume;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class A2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.a2, menu);
		return true;
	}
	
	 public boolean  onOptionsItemSelected(MenuItem mi)
	    {
	    	switch (mi.getItemId()) {
			case R.id.main:
				Intent i1=new Intent(A2.this, MainActivity.class);
				startActivity(i1);
				return true;

			case R.id.per:
				Intent i2=new Intent(A2.this, Personal.class);
				startActivity(i2);
				return true;

			case R.id.obj:
				Intent i3=new Intent(A2.this, Objective.class);
				startActivity(i3);
				return true;

			case R.id.con:
				Intent i4=new Intent(A2.this, Contact.class);
				startActivity(i4);
				return true;

	    	}
			return false;
	    	
	    }

}
