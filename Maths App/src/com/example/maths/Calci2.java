package com.example.maths;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView.OnEditorActionListener;

public class Calci2 extends Activity {

	Button btn1,btn2,btn3,btn4,btn5,btn6;
	EditText edt1;//text to be taken is input
	TextView tv,tv1;
	
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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calci2);
		
		btn1=(Button)findViewById(R.id.button1);//store the command for button
		btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        btn5=(Button)findViewById(R.id.button5);
        btn6=(Button)findViewById(R.id.button6);
        
        edt1=(EditText)findViewById(R.id.num4);//store the text given by the user
        
        tv=(TextView)findViewById(R.id.num5);//see the text to be displayed
        tv1=(TextView)findViewById(R.id.textView4);
        
        //set listeners
		edt1.addTextChangedListener(textWatcher);
        
		// run once to disable if empty
        checkFieldsForEmptyValues();
		
        
      //The code to check for any exception and display the error
    	edt1.setImeActionLabel("",EditorInfo.IME_ACTION_NEXT);

    	edt1.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_NEXT){
                    if( edt1.getText().toString().trim().equalsIgnoreCase(""))
                    	edt1.setError("Please Enter a Value!!!");
                    else
                        Toast.makeText(getApplicationContext(),"Notnull",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    	
    	


        
        btn1.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
            	Double d1=Double.parseDouble(edt1.getText().toString());
            	Double d2=Math.sin(Math.toRadians(d1));
                
                String s=Double.toString(d2);
                tv.setText(s);
                Toast.makeText(Calci2.this,"The Sine result is: "+d2, Toast.LENGTH_LONG).show();

            }
        });
        
          btn2.setOnClickListener(new View.OnClickListener() 
          {

                public void onClick(View v) 
                {
                	Double d1=Double.parseDouble(edt1.getText().toString());
                	Double d2=Math.cos(Math.toRadians(d1));
                    
                    String s=Double.toString(d2);
                    tv.setText(s);
                    Toast.makeText(Calci2.this,"The Cosine result is: "+d2, Toast.LENGTH_LONG).show();

                }
            }); 
          
          btn3.setOnClickListener(new View.OnClickListener() {

              public void onClick(View v)
              {
            	  Double d1=Double.parseDouble(edt1.getText().toString());
              	Double d2=Math.tan(Math.toRadians(d1));
                  
                  String s=Double.toString(d2);
                  tv.setText(s);
                  Toast.makeText(Calci2.this,"The Tan result is: "+d2, Toast.LENGTH_LONG).show();

              }
          }); 
          
          
          btn4.setOnClickListener(new View.OnClickListener() {

              public void onClick(View v)
              {
            	  Double d1=Double.parseDouble(edt1.getText().toString());
              	Double d2=Math.log(d1);
                  
                  String s=Double.toString(d2);
                  tv.setText(s);
                  Toast.makeText(Calci2.this,"The Log result is: "+d2, Toast.LENGTH_LONG).show();

              }
          }); 
          
          btn5.setOnClickListener(new View.OnClickListener() {

              public void onClick(View v)
              {
            	  Double d1=Double.parseDouble(edt1.getText().toString());
              	Double d2=Math.sqrt(d1);
                  
                  String s=Double.toString(d2);
                  tv.setText(s);
                  Toast.makeText(Calci2.this,"The SquareRoot is: "+d2, Toast.LENGTH_LONG).show();

              }
          }); 
          
          btn6.setOnClickListener(new View.OnClickListener() {

              public void onClick(View v)
              {
            	  Double d1=Double.parseDouble(edt1.getText().toString());
              	Double d2=Math.exp(d1);
                
              	String s=Double.toString(d2);
                  tv.setText(s);
                  Toast.makeText(Calci2.this,"The Exponential is: "+d2, Toast.LENGTH_LONG).show();

              }
          }); 
          
          tv1.setOnClickListener(new View.OnClickListener()
          {

              public void onClick(View v)
              {
                  Intent myintent2 = new Intent(Calci2.this,Curves.class);
                  startActivity(myintent2);

              }
          });


        
		
	}
	
	 private  void checkFieldsForEmptyValues()
	 {
	       
	        String s1 = edt1.getText().toString();
	       
	        if (s1.length() > 0 ) {
	            btn1.setEnabled(true);
	            btn2.setEnabled(true);
	            btn3.setEnabled(true);
	            btn4.setEnabled(true);
	            btn5.setEnabled(true);
	            btn6.setEnabled(true);
	        } else {
	        	 btn1.setEnabled(false);
		            btn2.setEnabled(false);
		            btn3.setEnabled(false);
		            btn4.setEnabled(false);
		            btn5.setEnabled(false);
		            btn6.setEnabled(false);
	        }
	       
	    }//end of function


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calci2, menu);
		return true;
	}

}
