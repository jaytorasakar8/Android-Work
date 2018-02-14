package com.example.tabactivitydemo;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.widget.TabHost.TabSpec;
 
public class MainActivity extends FragmentActivity {
	
	FragmentTabHost mTabHost;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        TabSpec Androidtab = mTabHost.newTabSpec("Android").setIndicator("", getResources().getDrawable(R.drawable.android_logo_config));
		
        TabSpec Appletab = mTabHost.newTabSpec("Apple").setIndicator("", getResources().getDrawable(R.drawable.icon_apple_config));
		
		TabSpec Windowstab = mTabHost.newTabSpec("Windows").setIndicator("", getResources().getDrawable(R.drawable.windows_config));
		
		TabSpec NokiaTab = mTabHost.newTabSpec("Nokia").setIndicator("", getResources().getDrawable(R.drawable.nokia_config));
		
		
		mTabHost.addTab(Androidtab, AndroidActivity.class , null);
		
		mTabHost.addTab(Appletab, AppleActivity.class, null);
		
		mTabHost.addTab(Windowstab, WindowActivity.class, null);
		
		mTabHost.addTab(NokiaTab, Nokia.class, null);
		
		mTabHost.setCurrentTab(0);
    }
}