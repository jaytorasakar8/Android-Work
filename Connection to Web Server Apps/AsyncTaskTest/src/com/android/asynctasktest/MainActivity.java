package com.android.asynctasktest;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
	String url;
	TextView tv1;
	Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		tv1=(TextView)findViewById(R.id.tv1);
		b=(Button)findViewById(R.id.b);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try
				{
					// CONNECTIVITY_SERVICE returns ConnectivityManager object
					ConnectivityManager c=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
					NetworkInfo n=c.getActiveNetworkInfo();// requires permission ACCESS_NETWORK_STATE
					if(n!=null && n.isConnected())
					{
				//url="http://10.0.2.2/test/asynctask_test.php";
				//new Background().execute("http://10.0.2.2/test/asynctask_test.php");
				new Background().execute("http://10.0.2.2:8081/HelloServlet/Hi");
						
					}
				}catch(Exception e){ System.out.print("Error : "+e.toString());}

			}
		});
	}
	
	class Background extends AsyncTask<String, Void, String>
	{
		String check="";
		
		protected void onPreExecute()
		{
			// This method runs on UI thread
			
			Toast.makeText(getBaseContext(), "Calling Background Thread", Toast.LENGTH_LONG).show();
			super.onPreExecute();
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			// This method runs on Background Thread
			
			HttpClient httpclient = new DefaultHttpClient();
	    	HttpGet httpget = new HttpGet(params[0]);
	    	HttpResponse response;
	        try
	        {
	           	response = httpclient.execute(httpget);
	        	//this execute makes the connection with app and server using URL and returns HttpResponse obj.
	        	if(response!=null)
	        	{
	        		if(response.getStatusLine().getStatusCode() == 200)
	        		{
	        			HttpEntity entity = response.getEntity();// obtain entity from the response
	        			
	        			if (entity != null)
	        			{
	        				// A Simple JSON Response Read
	        				InputStream instream = entity.getContent();
	        				
	        				check =convertStreamToString(instream);
	        				
	        				if(check.equals(""))
	        				{
	        					check="no data found from file";
	        				}	        				
	        			}
	        		}
	        	}
	        	
	        }
	        catch(Exception e)
	        {
	        	Log.d("---////////////---", e.toString());
	        }
	        return check;
		}
		
		public void onProgressUpdate()
		{
			//This method runs on UI thread
			// Not Used In this Program
			// Used to show user the progress of work being done in the Background Thread
		}
		
    	public void onPostExecute(String s)
    	{
    		//This method runs on UI thread
    			
    			Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
    	
    			tv1.setText(s);
    	
    	}

		
    	
    	
        private String convertStreamToString(InputStream is)
        {
        	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        	String data = "";
        	 
            String line = null;
            try
            {
                while ((line = reader.readLine()) != null)
                {
                	if(data == "")
                	{
                		data = line;
                		Log.d("--???????--", data);
                	}
                	else
                	{
                		data += "\n" + line;
                		Log.d("--!!!!!!!!!--", data);
                	}
                }
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
            finally
            {
                try
                {
                    is.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return data;
        }
	}
}
