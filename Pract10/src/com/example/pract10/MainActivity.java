package com.example.pract10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void click(View v)
    {
    		Intent i=new Intent(MainActivity.this,A2.class);
    		startActivityForResult(i, 1);
    }
    
    public void onActivityResult(int requestcode,int resultcode, Intent data)
    {
    	if(requestcode==1)
    	{
    		if(resultcode==RESULT_OK)
    		{
    			Toast.makeText(getBaseContext(), data.getData().toString(), Toast.LENGTH_LONG).show();
    		}
    		else
    		{
    			Toast.makeText(getBaseContext(), "Error in selcting data", Toast.LENGTH_LONG).show();
        		
    		}
    	}
    }
    
}
