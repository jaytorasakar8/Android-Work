package com.example.maths;


import android.app.Activity;
import android.os.Bundle;
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

public class Calci extends Activity {

	Button btn1,btn2,btn3,btn4;
	EditText edt1,edt2;//text to be taken is input
	TextView tv;
	
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
		setContentView(R.layout.activity_calci);
		
		btn1=(Button)findViewById(R.id.button1);//store the command for button
		btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        
        edt1=(EditText)findViewById(R.id.num1);//store the text given by the user
        edt2=(EditText)findViewById(R.id.num2);
        
        tv=(TextView)findViewById(R.id.num3);//see the text to be displayed
        
        
        //set listeners
		edt1.addTextChangedListener(textWatcher);
        edt2.addTextChangedListener(textWatcher);
        
		// run once to disable if empty
        checkFieldsForEmptyValues();
        
        
      //The code to check for any exception and display the error
    	edt1.setImeActionLabel("",EditorInfo.IME_ACTION_NEXT);

    	edt1.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_NEXT){
                    if( edt1.getText().toString().trim().equalsIgnoreCase(""))
                    	edt1.setError("Please Enter Number!!!");
                    else
                    	Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    	
    	edt2.setImeActionLabel("",EditorInfo.IME_ACTION_NEXT);

    	edt2.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_NEXT){
                    if( edt2.getText().toString().trim().equalsIgnoreCase(""))
                    	edt2.setError("Please Enter Number!!!");
                    else
                    	Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    	


        
        btn1.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
               Double d1=Double.parseDouble(edt1.getText().toString());
               Double d2=Double.parseDouble(edt2.getText().toString());
               Double d3=d1+d2;
               String s=Double.toString(d3);
               tv.setText(s);
               
               Toast.makeText(Calci.this,"The Addition result is: "+d3, Toast.LENGTH_LONG).show();

            }
        });
        
          btn2.setOnClickListener(new View.OnClickListener() 
          {

                public void onClick(View v) 
                {
                	Double d1=Double.parseDouble(edt1.getText().toString());
                    Double d2=Double.parseDouble(edt2.getText().toString());
                    Double d3=d1-d2;
                    String s=Double.toString(d3);
                    tv.setText(s);
                    Toast.makeText(Calci.this,"The Subraction result is: "+d3, Toast.LENGTH_LONG).show();

                }
            }); 
          
          btn3.setOnClickListener(new View.OnClickListener() {

              public void onClick(View v)
              {
            	  Double d1=Double.parseDouble(edt1.getText().toString());
                  Double d2=Double.parseDouble(edt2.getText().toString());
                  Double d3=d1*d2;
                  String s=Double.toString(d3);
                  tv.setText(s);
                  Toast.makeText(Calci.this,"The Multiplication result is: "+d3, Toast.LENGTH_LONG).show();
              }
          }); 
          
          
          btn4.setOnClickListener(new View.OnClickListener() 
          {

              public void onClick(View v)
              {
            	  Double d1=Double.parseDouble(edt1.getText().toString());
                  Double d2=Double.parseDouble(edt2.getText().toString());
                  Double d3=d1/d2;
                  String s=Double.toString(d3);
                  tv.setText(s);
                  Toast.makeText(Calci.this,"The Division result is: "+d3, Toast.LENGTH_LONG).show();
              }
          }); 

       
	}//end of oncreate
	
	 private  void checkFieldsForEmptyValues()
	 {
	       
	        String s1 = edt1.getText().toString();
	        String s2 = edt2.getText().toString();
	        
	        if (s1.length() > 0 && s2.length() > 0) {
	            btn1.setEnabled(true);
	            btn2.setEnabled(true);
	            btn3.setEnabled(true);
	            btn4.setEnabled(true);
	        } else {
	        	 btn1.setEnabled(false);
		            btn2.setEnabled(false);
		            btn3.setEnabled(false);
		            btn4.setEnabled(false);
	        }
	        
	 }//end of function


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calci, menu);
		return true;
	}

}
