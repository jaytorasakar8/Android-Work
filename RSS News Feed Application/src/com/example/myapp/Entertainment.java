package com.example.myapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class Entertainment extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entertainment);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.entertainment, menu);
		return true;
	}

	public boolean  onOptionsItemSelected(MenuItem mi)
    {
    	switch (mi.getItemId()) {
		case R.id.homepage:
			Intent i1=new Intent(Entertainment.this, HomePage.class);
			startActivity(i1);
			return true;

		case R.id.bookmark:
			Intent i2=new Intent(Entertainment.this, Bookmark.class);
			startActivity(i2);
			return true;

		case R.id.exit:
			Intent i3=new Intent(Entertainment.this, Test.class);
			startActivity(i3);
			return true;

    	}
		return false;
    	
    }
}
