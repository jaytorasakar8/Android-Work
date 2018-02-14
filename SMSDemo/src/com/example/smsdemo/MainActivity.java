package com.example.smsdemo;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	EditText editMob,editSMS;
	Button btnSend;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMob=(EditText)findViewById(R.id.editTextMob);
        editSMS=(EditText)findViewById(R.id.editTextSMS);
        btnSend=(Button)findViewById(R.id.buttonSend);
        //3 step process..
        btnSend.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String strMob=editMob.getText().toString();
		String strSMS=editSMS.getText().toString();
		//Concept of SMS....
		SmsManager smsManager=SmsManager.getDefault();
		//now you can send your sms
		smsManager.sendTextMessage(strMob, null, strSMS, null, null);
		Toast.makeText(this, "sms sent....", Toast.LENGTH_LONG).show();
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    
}
