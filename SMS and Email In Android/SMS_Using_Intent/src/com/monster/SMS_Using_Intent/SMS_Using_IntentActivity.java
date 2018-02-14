package com.monster.SMS_Using_Intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SMS_Using_IntentActivity extends Activity {
	Button btnSendSMS;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnSendSMS = (Button) findViewById(R.id.btnSendSMS);
        btnSendSMS.setOnClickListener(new View.OnClickListener()
        {
        public void onClick(View v)
        {
        	//sendSMS("5556", "Hello my friends!");
        		Intent i = new Intent(android.content.Intent.ACTION_VIEW);
        		i.putExtra("address", "5556;5558");
        		//i.putExtra("address", "5556; 5558; 5560");
        		i.putExtra("sms_body", "Hello my friends!");
        		i.setType("vnd.android-dir/mms-sms");
        		startActivity(i);
        }
        });
    }
}