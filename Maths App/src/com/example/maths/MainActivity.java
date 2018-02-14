package com.example.maths;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	Button btn1,btn2,btn3,btn4;
	EditText edt;//text to be taken is input
	TextView tv;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        
        btn1.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
                Intent myintent2 = new Intent(MainActivity.this,Curves.class);
                startActivity(myintent2);

            }
        });
        
          btn2.setOnClickListener(new View.OnClickListener() 
          {

                public void onClick(View v) 
                {
                    Intent myintent2 = new Intent(MainActivity.this,Calci1.class);
                    startActivity(myintent2);

                }
            }); 
          
          btn3.setOnClickListener(new View.OnClickListener() {

              public void onClick(View v) {
                  Intent myintent2 = new Intent(MainActivity.this,Bmi.class);
                  startActivity(myintent2);

              }
          }); 
          
          
          btn4.setOnClickListener(new View.OnClickListener() {

              public void onClick(View v) {
                  Intent myintent2 = new Intent(MainActivity.this,Age.class);
                  startActivity(myintent2);

              }
          }); 
    
    }//end of oncreate method
        
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
}
