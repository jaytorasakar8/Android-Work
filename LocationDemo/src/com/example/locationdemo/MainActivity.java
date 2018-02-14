package com.example.locationdemo;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, LocationListener
{

	Button btnGet;
    TextView tvLoc;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGet=(Button)findViewById(R.id.button);
        tvLoc=(TextView)findViewById(R.id.editText1);
        btnGet.setOnClickListener(this);
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		LocationManager lm= (LocationManager)getSystemService(LOCATION_SERVICE);// take location from user
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
		
		
	}


	@Override
	public void onLocationChanged(Location l)// this method is called as soon as the location is changed 
	{
		// TODO Auto-generated method stub
		// this method is called as soon sasa the location is changed
	   Double lat=l.getLatitude();
	   Double lng=l.getLongitude();
	   String loc=lat+" "+lng;
	   tvLoc.setText(loc);
	   
	   // go to window-> view -> other-> emulator control
	   // a new icon will be created on rhs side and from it we can give the coordinates to display during runtime
	   
	}


	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
    
}
