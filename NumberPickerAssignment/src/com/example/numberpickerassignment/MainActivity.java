package com.example.numberpickerassignment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	DatePicker dp1 ;
	TimePicker tp1;
	Button bt2;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_main);
		
		 dp1 =(DatePicker)findViewById(R.id.dp1);
		 tp1=(TimePicker) findViewById(R.id.tp1);
		 bt2 =(Button) findViewById(R.id.bt2);
		
		
		final NumberPicker np = (NumberPicker) findViewById(R.id.np);
		final TextView tv1 = (TextView) findViewById(R.id.tv1);
		final TextView tv2 = (TextView) findViewById(R.id.tv2);
	
		np.setMinValue(0);
		np.setMaxValue(10);
		
		np.setOnValueChangedListener(new OnValueChangeListener() {
			
			@Override
			public void onValueChange(NumberPicker picker, int oldvalue, int newvalue) {
				
				tv1.setText("Old Value: "+String.valueOf(oldvalue));
				tv2.setText("New Value: "+String.valueOf(newvalue));
					
			}
		});
		
		
	
		
	
		
		bt2.setOnClickListener(new OnClickListener() 
			{
			
			@Override
			public void onClick(View arg0) {
						int hour=tp1.getCurrentHour();
						int miniute=tp1.getCurrentMinute();
				
						Toast.makeText(getApplicationContext(), "time:"+hour+":"+miniute, Toast.LENGTH_LONG).show();
								
					
			}}); //end of button
				
			}
	
		
	
}
