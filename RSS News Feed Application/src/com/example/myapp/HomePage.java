package com.example.myapp;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomePage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}
	
	public void click(View v)
	{
		
		switch(v.getId())
		{
			case R.id.tr0: 
			
			String[] s0 = getResources().getStringArray(R.array.spiritual);
			
			 Intent i0=new Intent(getBaseContext(),Newspage.class);
			 i0.putExtra("img", s0[1]);
			 i0.putExtra("desc", s0[3]);
              startActivity(i0);
			
			break;
	
			case R.id.tr1: 
				
				String[] s1 = getResources().getStringArray(R.array.sports1);
				
				 Intent i1=new Intent(getBaseContext(),Newspage.class);
				 i1.putExtra("img", s1[1]);
				 i1.putExtra("desc", s1[3]);
	              startActivity(i1);
				
				break;
				
			case R.id.tr2: 
				
				String[] s2 = getResources().getStringArray(R.array.sports2);
				
				 Intent i2=new Intent(getBaseContext(),Newspage.class);
				 i2.putExtra("img", s2[1]);
				 i2.putExtra("desc", s2[3]);
	              startActivity(i2);
				
				break;
				
			case R.id.tr3: 
				
				String[] s3 = getResources().getStringArray(R.array.sports3);
				
				 Intent i3=new Intent(getBaseContext(),Newspage.class);
				 i3.putExtra("img", s3[1]);
				 i3.putExtra("desc", s3[3]);
	              startActivity(i3);
				
				break;
				
			case R.id.tr4: 
				
				String[] s4 = getResources().getStringArray(R.array.cars1);
				
				 Intent i4=new Intent(getBaseContext(),Newspage.class);
				 i4.putExtra("img", s4[1]);
				 i4.putExtra("desc", s4[3]);
	              startActivity(i4);
				
				break;
		
			case R.id.tr5: 
				
				String[] s5 = getResources().getStringArray(R.array.cars2);
				
				 Intent i5=new Intent(getBaseContext(),Newspage.class);
				 i5.putExtra("img", s5[1]);
				 i5.putExtra("desc", s5[3]);
	              startActivity(i5);
				
				break;
				
			case R.id.tr6: 
				
				String[] s6 = getResources().getStringArray(R.array.entertainment1);
				
				 Intent i6=new Intent(getBaseContext(),Newspage.class);
				 i6.putExtra("img", s6[1]);
				 i6.putExtra("desc", s6[3]);
	              startActivity(i6);
				
				break;
		}
	}
	
	
	public boolean  onOptionsItemSelected(MenuItem mi)
    {
    	switch (mi.getItemId()) {
		case R.id.spiritual:
			Intent i1=new Intent(HomePage.this, Spiritual.class);
			startActivity(i1);
			return true;

		case R.id.sports:
			Intent i2=new Intent(HomePage.this, Sports.class);
			startActivity(i2);
			return true;

		case R.id.cars:
			Intent i3=new Intent(HomePage.this, Cars.class);
			startActivity(i3);
			return true;

		case R.id.entertainment:
			Intent i4=new Intent(HomePage.this, Entertainment.class);
			startActivity(i4);
			return true;
			
		case R.id.bookmark:
			Intent i5=new Intent(HomePage.this, Bookmark.class);
			startActivity(i5);
			return true;

		case R.id.exit:
			Intent i6=new Intent(HomePage.this, Test.class);
			startActivity(i6);
			return true;

    	}
		return false;
    	
    }

}
