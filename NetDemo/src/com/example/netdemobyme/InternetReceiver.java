package com.example.netdemobyme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony.Sms;
import android.telephony.SmsManager;

public class InternetReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) 
	{
		// TODO Auto-generated method stub
		SmsManager sm=SmsManager.getDefault();
		sm.sendTextMessage("12345",null,"Text memory full",null,null);
		
		

	}

}
