package com.example.logindemobyme;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity 
{
	TextView tv;

	@Override
	//we need to override this method manually process: RC->source->implement methods
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second); //bcoz this is second activity 
		
		tv=(TextView)findViewById(R.id.textViewInfo); //in the second activity we need to have a text field to dislay the values
		
		Bundle bundle=getIntent().getExtras();//get the content from the Activity class and take extra values
		
	
		String u=bundle.getString("user"); // key 'user' taken fromthe activity class
		String p=bundle.getString("pass").toString();
		String info="Username:"+u+"\nPassword:"+p;
		tv.setText(info); // display the info on the second activity page
		
	}
	
	

}
