package com.monster.SMS_Programmatically;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

public class SMS_ProgrammaticallyActivity extends Activity {
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
        sendSMS("5556", "Hi  all !");
        }
        });
    }

    //---sends an SMS message to another device---
    private void sendSMS(String phoneNumber, String message)
    {
    SmsManager sms = SmsManager.getDefault();
    sms.sendTextMessage(phoneNumber, 
    		null, message, null, null);
    }
}





