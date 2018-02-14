package com.monster.DatabaseClass;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import android.database.Cursor;


//This is the one which has an interface to be shown to the user. 
public class DBHelperClassActivity extends Activity {
   private long id;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
      DBAdapter db = new DBAdapter(this); // calls the constructor > which calls the onCreate()
      //This statement binds the java file with the Activity so that no one can take control over the database other than this class      
      
      //---add a contact---
    /*  
     //
      db.open();
      id = db.insertContact("Rocky Jagtiani", "jagtiani_rocky@yahoo.com","+919892544177"); 
      id = db.insertContact("Suven Consultants", "courses.suvenconsultants.com","+919892544177");
      db.close();      
  
      //---get all contacts---
 */ 
      db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst())
        {
        do {
        DisplayContact(c);
        } while (c.moveToNext());
        }
        db.close();        

      
        //---update contact---
   
      int id=3;
     db.open();
        if (db.updateContact(id, "RJ", "abc@gmail.com","+919892544177"))
        Toast.makeText(this, "Update successful.", Toast.LENGTH_LONG).show();
        else
        Toast.makeText(this, "Update failed.", Toast.LENGTH_LONG).show();
        db.close();
    
      //---delete a contact---
       
    /*    int id=3;
       db.open();
        if (db.deleteContact(id))
        Toast.makeText(this, "Delete successful.", Toast.LENGTH_LONG).show();
        else
        Toast.makeText(this, "Delete failed.", Toast.LENGTH_LONG).show();
        db.close();
           */
        
    //---get a contact---
   /*   
      db.open();
      Cursor c = db.getContact(3);
      if (c.moveToFirst())
      DisplayContact(c);
      else
      Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
      db.close();
      
*/
  }
      
      public void DisplayContact(Cursor c)
      {
      Toast.makeText(this, "id: " + c.getString(0) + "\n" +
      		"Name: " + c.getString(1) + "\n" +
      		"Email: " + c.getString(2)+ "\n" +
    		"Phone: " + c.getString(3),
		      		Toast.LENGTH_LONG).show();
	}
}