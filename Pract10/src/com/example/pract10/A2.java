package com.example.pract10;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class A2 extends Activity {

	
	EditText et1;
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
	
	public void click1(View v)
	{
		
		et1=(EditText)findViewById(R.id.et1);
		Intent data =new Intent();
		data.setData(Uri.parse(et1.getText().toString()));
		
		setResult(RESULT_OK,data);
		finish();
	}

}
