package com.example.iodemo;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnInitListener {
	Button btn;
	EditText edt;
	TextView tv;
	TextToSpeech tts;
	 String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button1);
        edt=(EditText)findViewById(R.id.editText1);
        tv=(TextView)findViewById(R.id.textView1);
        btn.setOnClickListener(this);
    }
   
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		str=edt.getText().toString();
		tv.setText(str);
		Toast.makeText(this, str, Toast.LENGTH_LONG).show();
		tts=new TextToSpeech(this, this);
	}

	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		//will only speak default language i.e. UK
		tts.setLanguage(Locale.GERMAN);
		tts.speak(str, TextToSpeech.QUEUE_FLUSH, null);
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	


    
}
