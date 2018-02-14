package com.example.myapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class Spiritual extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spiritual);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spiritual, menu);
		return true;
	}
	
	public boolean  onOptionsItemSelected(MenuItem mi)
    {
    	switch (mi.getItemId()) {
		case R.id.homepage:
			Intent i1=new Intent(Spiritual.this, HomePage.class);
			startActivity(i1);
			return true;

		case R.id.bookmark:
			Intent i2=new Intent(Spiritual.this, Bookmark.class);
			startActivity(i2);
			return true;

		case R.id.exit:
			Intent i3=new Intent(Spiritual.this, Test.class);
			startActivity(i3);
			return true;

    	}
		return false;
    	
    }

}
