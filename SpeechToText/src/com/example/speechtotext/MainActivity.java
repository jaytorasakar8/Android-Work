package com.example.speechtotext;

import java.util.ArrayList;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
//won't work on laptop work on mobile, use internet connectivity
public class MainActivity extends Activity implements OnClickListener 
{
	EditText ed;
	Button btn;
	private final int RQ=123;// variable for using request code
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ed=(EditText)findViewById(R.id.edit1);
        btn=(Button)findViewById(R.id.button1);
        
        btn.setOnClickListener(this);
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Owrking with Intents
		//swithcing mechanism form activity to antoher activity
		Intent i= new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,Locale.getDefault());
		i.putExtra(RecognizerIntent.EXTRA_PROMPT, "say something");
		try
		{ // used so that sme devices dont' have a google built in voice recognizer
			
		//next activity shud be done
		startActivityForResult(i, RQ);}
		catch(Exception e){
			
		}
		
		
	}

	//method created using RC->source-> implement override methods
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch(requestCode)
		{
		case RQ:// make RQ final otherwise i gives error as it requires a const value
			
			if(requestCode==RESULT_OK && null!=data)// result is present and no data is sent by user
			{
				ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
				ed.setText(result.get(0));
						
			}
			break;
		}
		// then go to androidmanifest.xml file 
// and then give 2 permissions internet and network		
	}
	
	
	//go to phpone and copuy the apk and then rn the apk
	
    
}
