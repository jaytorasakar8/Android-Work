package com.example.maths;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Curves3 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_curves3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.curves3, menu);
		return true;
	}

}
