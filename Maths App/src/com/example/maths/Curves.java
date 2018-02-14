package com.example.maths;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class Curves extends Activity 
{
	
	String[] curves={"y=x","y=x^2","x=y^2","y=x^3","sin x","cos x","tan x","e^x"};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_curves);
		ListAdapter arrayAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,curves);
		
		ListView list=(ListView)findViewById(R.id.list1) ;
		list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new OnItemClickListener()
        {
        	
        	public void onItemClick(AdapterView<?> parent, View view,
        		      int position, long id)
        		{
        		    switch( position )
        		    {
        		       case 0:  Intent newActivity1 = new Intent(Curves.this, Curves1.class);     
        		                startActivity(newActivity1);
        		                break;
        		       case 1:  Intent newActivity2 = new Intent(Curves.this, Curves2.class);     
        		       			startActivity(newActivity2);
        		       			break;
        		       case 2:  Intent newActivity3 = new Intent(Curves.this, Curves3.class);     
		                		startActivity(newActivity3);
		                		break;
        		       case 3:  Intent newActivity4 = new Intent(Curves.this, Curves4.class);     
        		       			startActivity(newActivity4);
        		       			break;
        		       case 4:  Intent newActivity5 = new Intent(Curves.this, Curves5.class);     
		                		startActivity(newActivity5);
		                		break;
        		       case 5:  Intent newActivity6 = new Intent(Curves.this, Curves6.class);     
               					startActivity(newActivity6);
               					break; 	
        		       case 6:  Intent newActivity7 = new Intent(Curves.this, Curves7.class);     
      							startActivity(newActivity7);
      							break; 	
        		       case 7:  Intent newActivity8 = new Intent(Curves.this, Curves8.class);     
      							startActivity(newActivity8);
      							break; 	
        		    }//end of switch case
        		}
        });//end of onitemclicklistener
        

	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.curves, menu);
		return true;
	}

}
