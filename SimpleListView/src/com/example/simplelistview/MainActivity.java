package com.example.simplelistview;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity implements OnItemClickListener {
	
	String[] days={"MONDAY","TUESDAY",
			"WEDNESDAY","THRUSDAY","FRIDAY","SATURDAY","SUNDAY"};
	ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        arrayAdapter=new ArrayAdapter<String>(this, R.layout.activity_main, days);
        setListAdapter(arrayAdapter);
        ListView lv=getListView();
        lv.setOnItemClickListener(this);
    }
	@Override
	public void onItemClick(AdapterView<?> parent,
			View list, int position, long id) {
		// TODO Auto-generated method stub
		String str=parent.getItemAtPosition(position).toString();
		Toast.makeText(this, "Good Morning it's "+str, 
				Toast.LENGTH_LONG).show();
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    
}
