package com.example.mediademo;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button btnStart,btnStop;
	MediaPlayer mediaPlayer;
	String DATA_SOURCE="/sdcard/malgudi_days.mp3";
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnStart=(Button)findViewById(R.id.buttonStart);
        btnStop=(Button)findViewById(R.id.buttonStop);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.buttonStart:
			playAudio();
			break;
		case R.id.buttonStop:
			killMedia();
			break;
		}
	}
	
    private void killMedia() {
		// TODO Auto-generated method stub
		if(mediaPlayer!=null){
			mediaPlayer.release();
		}
	}

	private void playAudio() {
		// TODO Auto-generated method stub
		killMedia();
		try {
			mediaPlayer=new MediaPlayer();
			mediaPlayer.setDataSource(DATA_SOURCE);
			mediaPlayer.prepare();
			mediaPlayer.start();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    
}
