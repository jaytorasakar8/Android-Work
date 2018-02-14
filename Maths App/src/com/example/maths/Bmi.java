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
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class Bmi extends Activity {

	Button btn1;
	EditText edt1,edt2;//text to be taken is input
	TextView tv;
	
	
	///////Step 1: Declare a Textwatcher so that we can see if the user has entered any value in the editText blanks.
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
		setContentView(R.layout.activity_bmi);
	
	//////////Step 2: Basic declarations and definitions of variables so that the var can be assigned the buttons and text field values	
		//Basic Definitions/declarations
		btn1=(Button)findViewById(R.id.button1);
		
		edt1=(EditText)findViewById(R.id.num6);//store the text given by the user
		edt2=(EditText)findViewById(R.id.num7);
		
		tv=(TextView)findViewById(R.id.num8);
		
	///////////Step 3: Set listeners and call the functions so that we can check for empty values	
		 //set listeners
		edt1.addTextChangedListener(textWatcher);
        edt2.addTextChangedListener(textWatcher);
        
		// run once to disable if empty
        checkFieldsForEmptyValues();
		
   ////////////Step 4: FOr displaying any customized error for the user. 
		//The code to check for any exception and display the error
    	edt1.setImeActionLabel("",EditorInfo.IME_ACTION_NEXT);

    	edt1.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_NEXT){
                    if( edt1.getText().toString().trim().equalsIgnoreCase(""))
                    	edt1.setError("Please Enter Weight!!!");
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
                    	edt2.setError("Please Enter Height!!!");
                    else
                        Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT);
                }
                return false;
            }
        });
    	

   /////////////Step 5: actual code which performs the calculation
		//Actual code which is used for calculations 
		 btn1.setOnClickListener(new View.OnClickListener()
	        {
			 	 
			 public void onClick(View v)
	            {
	            	//Actual code to calculate bmi
	            	Double d1=Double.parseDouble(edt1.getText().toString());
	            	Double d2=Double.parseDouble(edt2.getText().toString());
	            	Double bmi= d1/((d2)*(d2));
	                
	                String s=Double.toString(bmi);
	                tv.setText(s);
	                
	                Toast.makeText(Bmi.this,"Your BMI is "+bmi, Toast.LENGTH_LONG).show();
	            }
	        });

		
	} //end of oncreate
	
	
	 private  void checkFieldsForEmptyValues()
	 {
	       
	        String s1 = edt1.getText().toString();
	        String s2 = edt2.getText().toString();

	        if(s1.equals("") && s2.equals(""))
	        {
	            btn1.setEnabled(false);
	        }

	        else
	        {
	        	if(!s1.equals("")&&s2.equals(""))
	        	{
	        	btn1.setEnabled(false);
	        	}

	        	else
	        	{	if(!s2.equals("")&&s1.equals(""))
	        		{
	        			btn1.setEnabled(false);
	        		}

	        		else
	        		{
	        			btn1.setEnabled(true);
	        		}
	        	}
	        }//end of outer most else
	    }//end of function

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bmi, menu);
		return true;
	}

}
