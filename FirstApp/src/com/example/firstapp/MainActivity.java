package com.example.firstapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/*
 * simple application to take the input from user and display the output to the user
 */
public class MainActivity extends Activity implements OnClickListener 
{	Button btn;
	EditText edt;//text to be taken is input
	TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button1);//store the command for button
        edt=(EditText)findViewById(R.id.editText1);//store the text given by the user
        tv=(TextView)findViewById(R.id.textView);//see the text to be displayed
       
       btn.setOnClickListener(this);//tell what to do when the button is clicked
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0)
	{
		// TODO Auto-generated method stub
		String str=edt.getText().toString();//whatever the text given to the edt variable, take the content 
		// and then convert to string and store in str
		tv.setText(str);//using tv variable we are trying to display the text given to us
		//set method is to display the text(generally) in android
		//get method is used to take input from android 
		
		
	}
    
}
