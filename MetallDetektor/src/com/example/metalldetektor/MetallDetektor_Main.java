package com.example.metalldetektor;


import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.FloatMath;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MetallDetektor_Main extends Activity implements SensorEventListener {

	String TAG = "FPT Lehrlinge";
	Sensor sensor_magnet = null;
	ProgressBar progressBar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metall_detektor_main);
        
        final Button btnStart = (Button) findViewById(R.id.btnStart);
        final Button btnStop = (Button) findViewById(R.id.btnStop);
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        final TextView msgError = (TextView) findViewById(R.id.msgError);
        
        
        SensorManager sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor_magnet = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sm.registerListener(this, sensor_magnet, SensorManager.SENSOR_DELAY_NORMAL);
//        if(sensor_magnet == null) {
//        	msgError.setText("Sensor existiert nicht!");
//        }
//        else {
//        	msgError.setText("Sensor existiert!");
//        }
        
        

        btnStart.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        	btnStop.setEnabled(true);
        	btnStart.setEnabled(false);
        	progressBar1.setVisibility(View.VISIBLE);
        	
    		}
        });
        
        btnStop.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        	btnStop.setEnabled(false);
        	btnStart.setEnabled(true);
        	progressBar1.setVisibility(View.INVISIBLE);
    		}
        });
    }
    
    public void onSensorChanged(SensorEvent event) {
    	if(event.sensor == sensor_magnet) {
    		float[] mag = event.values;
    		double betrag = FloatMath.sqrt(mag[0] + mag[1] * mag[1] + mag[2] * mag[2]);
    		progressBar1.setProgress((int) betrag);
    		Log.w(TAG, Double.toString(betrag));
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.metall_detektor__main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
}
