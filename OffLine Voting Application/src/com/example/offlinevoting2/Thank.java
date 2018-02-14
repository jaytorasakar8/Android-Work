package com.example.offlinevoting2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Thank extends Activity {
Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thank);
		b1=(Button) findViewById(R.id.thankb);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i4=new Intent(getBaseContext(),MainActivity.class);
				i4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i4.putExtra("exit", true);
				startActivity(i4);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.thank, menu);
		return true;
	}

}
