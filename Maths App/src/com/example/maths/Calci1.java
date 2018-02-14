package com.example.maths;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calci1 extends Activity {

	Button btn1,btn2,btn3,btn4;
	EditText edt;//text to be taken is input
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calci1);
		
		btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        

        btn1.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
                Intent myintent2 = new Intent(Calci1.this,Calci.class);
                startActivity(myintent2);

            }
        });
        
          btn2.setOnClickListener(new View.OnClickListener() 
          {

                public void onClick(View v) 
                {
                    Intent myintent2 = new Intent(Calci1.this,Calci2.class);
                    startActivity(myintent2);

                }
            }); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calci1, menu);
		return true;
	}

}
