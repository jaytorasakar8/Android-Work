package com.example.offlinevoting2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Vote extends Activity {
TextView vtt1,vtt2,vtt3,vtt4;
String User_id;
String entryarray[];
String votingarr[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vote);
		
		vtt1 = (TextView) findViewById(R.id.votetv2);
		vtt2 = (TextView) findViewById(R.id.votetv3);
		vtt3 = (TextView) findViewById(R.id.votetv4);
		vtt4 = (TextView) findViewById(R.id.votetv5);
		
		Bundle b2=getIntent().getExtras();
		User_id = b2.getString("id");
		Toast.makeText(getBaseContext(),User_id,Toast.LENGTH_SHORT).show();
		vtt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Voting();
				UpdateVotes(0);
			
			}
		});
		vtt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Voting();
				UpdateVotes(1);
			}
		});
		
		vtt3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Voting();
				UpdateVotes(2);
			}
		});
		vtt4.setOnClickListener(new OnClickListener() {
			@Override
	public void onClick(View arg0) {
		Voting();
		UpdateVotes(3);
			}
		});
	}
	
	public void Voting() 
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
				Toast.makeText(getBaseContext(),"Reading File",Toast.LENGTH_SHORT).show();
				String readString =String.copyValueOf(inputBuffer,0,charRead);
				s+=readString;
				inputBuffer =new char[100];
				Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();	
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
			for(int i=0;i<entryarray.length;i=i+3)
			{
				Toast.makeText(getBaseContext(),"Reading Array",Toast.LENGTH_SHORT).show();
				
				
				if(User_id.equals(entryarray[i]))
				{	
					f1=1;
					Toast.makeText(getBaseContext(),"Updating Voting Status",Toast.LENGTH_SHORT).show();
					entryarray[i+2]="1";
					//Toast.makeText(getBaseContext(),entryarray[2],Toast.LENGTH_SHORT).show();
					  FileOutputStream fOut =
						        openFileOutput("Textfile.txt", MODE_PRIVATE); // File creation mode: allow all other applications to have read access to the created file.
						        OutputStreamWriter osw = new OutputStreamWriter(fOut);
					        String strco="";
						        //---write the string to the file---
						        for(int j=0;j<entryarray.length;j++)
						        {
						        	strco=strco+entryarray[j]+",";
						        }
						        Toast.makeText(getBaseContext(),strco,Toast.LENGTH_SHORT).show();
								osw.write(strco);
						        osw.flush();
						        osw.close();
					
				}
				
			}
		} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		
	}
	
public void UpdateVotes(int l){
	try 
	{
		int size=l;
		String s="";
		FileInputStream fin=openFileInput("Vote.txt");
		InputStreamReader isr=new InputStreamReader(fin);
		char[] inputBuffer =new char[100];
		int charRead;
		while((charRead =isr.read(inputBuffer))>0)
		{	
			Toast.makeText(getBaseContext(),"Reading File",Toast.LENGTH_SHORT).show();
			String readString =String.copyValueOf(inputBuffer,0,charRead);
			s+=readString;
			inputBuffer =new char[100];
			Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();	
		}
		if(s!=null)
		{
			votingarr=s.split(",");
		}
		else
		{
			Toast.makeText(getBaseContext(),"File Not Loaded",Toast.LENGTH_SHORT).show();
		}
		int count=Integer.parseInt(votingarr[size]);
		count=count +1;
		votingarr[size]=Integer.toString(count);
		for(int i=0;i<votingarr.length;i++)
		{
			Toast.makeText(getBaseContext(),"Reading Array",Toast.LENGTH_SHORT).show();
			
			
			
			
			{	
		
				//Toast.makeText(getBaseContext(),entryarray[2],Toast.LENGTH_SHORT).show();
				  FileOutputStream fOut =
					        openFileOutput("Vote.txt", MODE_PRIVATE); // File creation mode: allow all other applications to have read access to the created file.
					        OutputStreamWriter osw = new OutputStreamWriter(fOut);
				        String cp="";
					        //---write the string to the file---
					        for(int j=0;j<votingarr.length;j++)
					        {
					        	cp=cp+votingarr[j]+",";
					        }
					        Toast.makeText(getBaseContext(),cp,Toast.LENGTH_SHORT).show();
							osw.write(cp);
					        osw.flush();
					        osw.close();
				
			}
			
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

