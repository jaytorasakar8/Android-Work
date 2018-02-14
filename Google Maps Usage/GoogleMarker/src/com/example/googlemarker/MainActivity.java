package com.example.googlemarker;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {
	 
	private GoogleMap map;
	private final LatLng chembur=new LatLng(19.062577, 72.901253);
	private final LatLng Dadar=new LatLng(19.016339, 72.840289);
	private final LatLng Dombivali=new LatLng(19.217066,73.083272);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       
        
        map=((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
    }
    
	 public void click_chembur(View v){
		 map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		 CameraUpdate update=CameraUpdateFactory.newLatLngZoom(chembur,16);
		 map.animateCamera(update);
		 
		 MarkerOptions marker=new MarkerOptions().position(chembur).title("Chembur");
		 marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
		 map.addMarker(marker);
	 }
	 

	 public void click_dadar(View v){
		 map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
		 CameraUpdate update=CameraUpdateFactory.newLatLngZoom(Dadar,16);
		 map.animateCamera(update);
		 MarkerOptions marker=new MarkerOptions().position(Dadar).title("Dadar");
		 marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
		 map.addMarker(marker);
	 }
	 
	 public void click_dombivali(View v){
		 map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		 CameraUpdate update=CameraUpdateFactory.newLatLngZoom(Dombivali,16);
		 map.animateCamera(update);
		 MarkerOptions marker=new MarkerOptions().position(Dombivali).title("Dombivali");
		 marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
		 map.addMarker(marker);
	 }
 
}
