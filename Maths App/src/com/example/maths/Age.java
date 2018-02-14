package com.example.maths;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class Age extends Activity {

	long a=0;
	Button btn1;
	EditText et1,et2,et3;//text to be taken is input
	TextView tv1;
	
	private TextWatcher textWatcher = new TextWatcher() 
	{
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3)
       {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            checkFieldsForEmptyValues();
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    }; //end of text watcher
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_age);
		 et1 = (EditText) findViewById (R.id.editText1);
       et2 = (EditText) findViewById (R.id.editText2);
       et3 = (EditText) findViewById (R.id.editText3);
        btn1=(Button)findViewById(R.id.button1);
        tv1 = (TextView) findViewById (R.id.editText4);
        
      //set listeners
      		et1.addTextChangedListener(textWatcher);
              et2.addTextChangedListener(textWatcher);
              et3.addTextChangedListener(textWatcher);
              
      		// run once to disable if empty
              checkFieldsForEmptyValues();
              
        
      //The code to check for any exception and display the error
    	et1.setImeActionLabel("",EditorInfo.IME_ACTION_NEXT);

    	et1.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_NEXT){
                    if( et1.getText().toString().trim().equalsIgnoreCase(""))
                    	et1.setError("Please Enter Date!!!");
                    else
                    	Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT);
                }
                return false;
            }
        });
    	
    	et2.setImeActionLabel("",EditorInfo.IME_ACTION_NEXT);

    	et2.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_NEXT){
                    if( et2.getText().toString().trim().equalsIgnoreCase(""))
                    	et2.setError("Please Enter Month!!!");
                    else
                    	Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT);
                }
                return false;
            }
        });
    	
    	et3.setImeActionLabel("",EditorInfo.IME_ACTION_NEXT);

    	et3.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_NEXT){
                    if( et3.getText().toString().trim().equalsIgnoreCase(""))
                    	et3.setError("Please Enter Year!!!");
                    else
                    	Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT);
                }
                return false;
            }
        });
    	



        btn1.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                int day = Integer.parseInt(et1.getText().toString());
                int month = Integer.parseInt(et2.getText().toString());
                int year = Integer.parseInt(et3.getText().toString());

                tv1.setText(String.valueOf(Age.this.getAge(year, month, day)));
                String age=String.valueOf(Age.this.getAge(year, month, day));
                Toast.makeText(Age.this,"Your Age is "+age+" Years", Toast.LENGTH_LONG).show();
            }
        });
	}

	 public int getAge (int _year, int _month, int _day) {

	        GregorianCalendar cal = new GregorianCalendar();
	        int y, m, d, a;         

	        y = cal.get(Calendar.YEAR);
	        m = cal.get(Calendar.MONTH);
	        d = cal.get(Calendar.DAY_OF_MONTH);
	        cal.set(_year, _month, _day);
	        a = y - cal.get(Calendar.YEAR);
	        if ((m < cal.get(Calendar.MONTH))
	                        || ((m == cal.get(Calendar.MONTH)) && (d < cal
	                                        .get(Calendar.DAY_OF_MONTH)))) {
	                --a;
	        }
	        if(a < 0)
	                throw new IllegalArgumentException("Age < 0");
	        return a;
	    }// end of getAge
	 
	 

	 private  void checkFieldsForEmptyValues()
	 {
	       
	        String s1 = et1.getText().toString();
	        String s2 = et2.getText().toString();
	        String s3 = et3.getText().toString();
	        
	        if (s1.length() > 0 && s2.length() > 0 && s3.length() >0) {
	            btn1.setEnabled(true);
	        } else {
	            btn1.setEnabled(false);
	        }
	        
	     
	    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.age, menu);
		return true;
	}

}
