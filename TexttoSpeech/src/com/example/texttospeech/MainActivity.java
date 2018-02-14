package com.example.texttospeech;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements android.view.View.OnClickListener, OnInitListener 
{
	Button btn;
	EditText edt;
	TextToSpeech tts;
	String str;
	TextView tv; // i want to display the given text by user, we use textview to display the text
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // take the content as input and store the result in btn and edt variables
        btn=(Button)findViewById(R.id.button1);//store the command for button
        edt=(EditText)findViewById(R.id.text1);//store the text given by the user
        tv=(TextView)findViewById(R.id.text2);
        
        btn.setOnClickListener(this);// when we click on button, the button object will call the listener and pass this class's
        // object as a parameter. so it will know that this activity was the one to call.
        //
     }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
		}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		str=edt.getText().toString();// retrieve the text given in object variable using getText() and convert to string 
		tv.setText(str);// in the bar where we have to display the text we take the same string and using setText we display it
		tts=new TextToSpeech(this, this);//call onInit and convert the string to speech using inbuilt text converter
	}


	@Override
	public void onInit(int arg0) {
		// TODO Auto-generated method stub
		//called when TextToSpeech has been called
		tts.setLanguage(Locale.US);
		tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);
	}
    
}
