package com.example.logindemobyme;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener 
{	
	EditText editUser,editPass;
	Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        editUser=(EditText)findViewById(R.id.editTextUser);
        editPass=(EditText)findViewById(R.id.editTextPassword);
        btnLogin=(Button)findViewById(R.id.button1);
        
        btnLogin.setOnClickListener(this);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String u=editUser.getText().toString();
		String p=editPass.getText().toString();
		
		Intent intent= new Intent(); // for moving from source to destination
		intent.setClass(this, SecondActivity.class); // moving from this class(login activiity to second actibity)
		
		intent.putExtra("user", u);// display the   username
		intent.putExtra("pass", p); // used for password 

		startActivity(intent);// call the other activity and then pass on the values
	
	}
    
}
