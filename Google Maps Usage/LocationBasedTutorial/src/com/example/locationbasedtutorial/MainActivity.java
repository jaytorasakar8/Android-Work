package com.example.locationbasedtutorial;

import java.security.PublicKey;

import android.app.Dialog;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
 
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
 
public class MainActivity extends FragmentActivity  {
 
    GoogleMap googleMap;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Getting Google Play availability status
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
 
        // Showing status
        if(status!=ConnectionResult.SUCCESS){ // Google Play Services are not available
 
            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();
 
        }else { // Google Play Services are available
 
            // Getting reference to the SupportMapFragment of activity_main.xml
            SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
 
            // Getting GoogleMap object from the fragment
            googleMap = fm.getMap();
 
            // Enabling MyLocation Layer of Google Map
            googleMap.setMyLocationEnabled(true);
 
            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
				
				@Override
				public void onMapClick(LatLng arg0) {
					// TODO Auto-generated method stub
					LatLng latLng = arg0;
					 
	                // Clears the previously touched position
	                googleMap.clear();
	 
	                // Animating to the touched position
	                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
	 
	                // Creating a marker
	                MarkerOptions markerOptions = new MarkerOptions();
	 
	                // Setting the position for the marker
	                markerOptions.position(latLng);
	                
	                double lat=latLng.latitude;
	                double log=latLng.longitude;
	 
	                // Placing a marker on the touched position
	                googleMap.addMarker(markerOptions);
	                
	                DisplayToast(lat, log);
	             
				}
			});
            
           
        }
    }
    
    public void DisplayToast(double lat,double log){
    	
    	 Toast.makeText(this,"Latitude:" +  lat  + ", Longitude:"+ log , Toast.LENGTH_LONG).show();
         
    }
      
}
