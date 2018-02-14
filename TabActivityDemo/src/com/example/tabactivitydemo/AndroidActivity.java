package com.example.tabactivitydemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.os.Bundle;
 
public class AndroidActivity extends Fragment {
    
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.activity_android, container, false);
		
		return v;
        
	}
}
