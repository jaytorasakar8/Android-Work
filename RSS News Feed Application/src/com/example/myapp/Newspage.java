package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Newspage extends Activity {

	TextView tv1;
	ImageView img1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newspage);
		
		String s1=getIntent().getStringExtra("img");
		String s2=getIntent().getStringExtra("desc");
		
		
		int res0=getResources().getIdentifier(s1, "drawable", this.getPackageName());
		
		tv1=(TextView)findViewById(R.id.tv1);
		img1=(ImageView)findViewById(R.id.img1);
		
		
		tv1.setText(s2);
	    img1.setImageResource(res0); ///////// still to be coded
		Toast.makeText(getBaseContext(), ""+s1+"\n"+s2, Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.newspage, menu);
		return true;
	}

}
