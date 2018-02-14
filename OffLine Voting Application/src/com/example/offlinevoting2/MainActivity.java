package com.example.offlinevoting2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
Button Ub2,Ub1;
EditText Ue1,Ue2;
String Us1,Us2;
String entryarray[]={""};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Ue1=(EditText) findViewById(R.id.editText1);
		Ue2=(EditText) findViewById(R.id.editText2);
		Ub1=(Button) findViewById(R.id.button1);
		Ub2=(Button) findViewById(R.id.button2);
	
		
		Ub1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Us1=Ue1.getText().toString();
				 Us2=Ue2.getText().toString();
				// TODO Auto-generated method stub
				//Toast.makeText(getBaseContext(),"hiii"+Ue1.getText().toString() +Ue2.getText().toString()+"bye",Toast.LENGTH_LONG).show();
				if(Us1.equals("")||Us2.equals(""))
				{
					Toast.makeText(getBaseContext(),"Please Enter all Field",Toast.LENGTH_LONG).show();
				}
				else
				{
					try 
					{
						String s="";
						FileInputStream fin=openFileInput("Textfile.txt");
						InputStreamReader isr=new InputStreamReader(fin);
						char[] inputBuffer =new char[100];
						int charRead;
						while((charRead =isr.read(inputBuffer))>0)
						{	
							//Toast.makeText(getBaseContext(),"Reading File",Toast.LENGTH_SHORT).show();
							String readString =String.copyValueOf(inputBuffer,0,charRead);
							s+=readString;
							inputBuffer =new char[100];
							//Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();	
						}
						if(s!=null)
						{
							entryarray=s.split(",");
						}
						else
						{
							Toast.makeText(getBaseContext(),"File Not Loaded",Toast.LENGTH_SHORT).show();
						}
						int f1=0;
						int f2=0;
						for(int i=0;i<entryarray.length;i=i+3)
						{
							//Toast.makeText(getBaseContext(),"Reading Array",Toast.LENGTH_SHORT).show();
							
							
							if(Us1.equals(entryarray[i]) && Us2.equals(entryarray[i+1]))
							{	
								 f1=1;
								if(entryarray[i+2].equals("0") && f2==0)
								{
									f2=1;
									Intent i1=new Intent(getBaseContext(),Vote.class);
									Bundle b = new Bundle();
									b.putString("id", entryarray[i]);
									i1.putExtras(b);
									startActivity(i1);
									
								}
							}
							
						}
						if(f1==0)
						{
							Toast.makeText(getBaseContext(),"Check Login Id & Aadhar Number",Toast.LENGTH_SHORT).show();
						}
						if(f2==1)
						{
							Toast.makeText(getBaseContext(),"Sorry!!! Yo have already voted",Toast.LENGTH_SHORT).show();
							
						}
					} catch (FileNotFoundException e) 
						{
							e.printStackTrace();
						} catch (IOException e) 
						{
							e.printStackTrace();
						}
					
					
					
				}
				
			}
		});
		
		
		Ub2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getBaseContext(), Admin.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
