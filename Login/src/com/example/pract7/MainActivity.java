package com.example.pract7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void view(View v) 
    {
		// TODO Auto-generated method stub
    	Bundle b1=new Bundle();
    	Intent i=new Intent(MainActivity.this, A2.class);
    	
    	t1=(EditText)findViewById(R.id.et1);
    	t2=(EditText)findViewById(R.id.et2);

    	String s=t1.getText().toString();
    	String s1=t2.getText().toString();

    	b1.putString("username",s);
    	b1.putString("password",s1);
    	i.putExtras(b1);

    	startActivity(i);


    }
    
}


//If you want to validate the login details without the use of bundles. It will show go to A2 in case of valid login.
/*  ////////MainActivity.java
 * 
 * public class MainActivity extends Activity {

	EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void view(View v) 
    {
    t1=(EditText)findViewById(R.id.et1);
t2=(EditText)findViewById(R.id.et2);

String s=t1.getText().toString();
String s1=t2.getText().toString();
 if(s.equals("ad") && s1.equals("pq"))
{
   	Intent i=new Intent(MainActivity.this, A2.class);
startActivity(i);
	
}
else
{
	Toast.makeText(getBaseContext(), "Error during login", Toast.LENGTH_LONG).show();
}

    }
    
}


/////Activity A2
 * 
 * public class A2 extends Activity {

	TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a2);
		
		tv1=(TextView) findViewById(R.id.tv1);
	tv1.setText("Welcome admin");
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.a2, menu);
		return true;
	}

}

 
 
 */

