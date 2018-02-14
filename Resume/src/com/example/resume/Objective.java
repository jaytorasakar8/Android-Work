package com.example.resume;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Objective extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_objective);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.objective, menu);
		return true;
	}

}
