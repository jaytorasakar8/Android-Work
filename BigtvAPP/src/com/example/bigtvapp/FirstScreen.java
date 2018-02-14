package com.example.bigtvapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
public class FirstScreen extends Activity implements OnClickListener {
	Button button;
    ListView listView;
    ArrayAdapter<String> adapter;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);
 
        findViewsById(); //our method to initialize the binding of our button and listview
 
        String[] sports = getResources().getStringArray(R.array.sports_array);
        
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, sports);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);
 
        button.setOnClickListener(this); //call goes to onclick
    }
 
    private void findViewsById() {
        listView = (ListView) findViewById(R.id.list);
        button = (Button) findViewById(R.id.testbutton);
    }
    
 //this method is called whenever we click on the submit button
    public void onClick(View v) 
    {
        SparseBooleanArray checked = listView.getCheckedItemPositions();//get all the index positions of items which are  be checked
        
        ArrayList<String> selectedItems = new ArrayList<String>();//add all the items to array list which have been selected.
        
        //checks all the items in the array i.e.listview whether they are checked or not
        for (int i = 0; i < checked.size(); i++) {
            // Item position in adapter
            int position = checked.keyAt(i);
            // Add sport if it is checked i.e.) == TRUE!
            if (checked.valueAt(i))
                selectedItems.add(adapter.getItem(position));
        }
 
        String[] outputStrArr = new String[selectedItems.size()];
 
        for (int i = 0; i < selectedItems.size(); i++) {
            outputStrArr[i] = selectedItems.get(i);
        }
 
        Intent intent = new Intent(getApplicationContext(),
                ResultActivity.class);
 
        // Create a bundle object
        Bundle b = new Bundle();
        b.putStringArray("selectedItems", outputStrArr);
 
        // Add the bundle to the intent.
        intent.putExtras(b);
 
        // start the ResultActivity
        startActivity(intent);
        finish();
    }
}
