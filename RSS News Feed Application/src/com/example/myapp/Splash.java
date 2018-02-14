package com.example.myapp;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class Splash extends Activity {
	

	private static final int READ_BLOCK_SIZE=100;
	String file="mydata.txt";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		 new Thread() {// Create Thread that will sleep for 5 seconds  
	            public void run() {
	                 
	                try {
	                    // Thread will sleep for 5 seconds
	                    sleep(2*1000);
	             
	                    // Toast.makeText(getBaseContext(), "s", Toast.LENGTH_SHORT).show();
	                    Intent i=new Intent(Splash.this,HomePage.class);
		                   startActivity(i);
		                   finish();
	                }
	                    
	                
	                
	                 catch (Exception e) {
	                 
	                 }     
	            }//end of run
	        }.start();
		 
	        
	}//end of oncreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}//end of class