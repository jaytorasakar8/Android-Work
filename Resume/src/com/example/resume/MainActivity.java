package com.example.resume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu); //Inflate the menu from the main.xml file from the menu folder
        return true;
    }
    
    public boolean  onOptionsItemSelected(MenuItem mi)
    {
    	switch (mi.getItemId()) {
		case R.id.edu:
			Intent i1=new Intent(MainActivity.this, A2.class);
			startActivity(i1);
			return true;

		case R.id.per:
			Intent i2=new Intent(MainActivity.this, Personal.class);
			startActivity(i2);
			return true;

		case R.id.obj:
			Intent i3=new Intent(MainActivity.this, Objective.class);
			startActivity(i3);
			return true;

		case R.id.con:
			Intent i4=new Intent(MainActivity.this, Contact.class);
			startActivity(i4);
			return true;

    	}
		return false;
    	
    }
}
