package com.example.metalldetektor;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class MetallDetektor_Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metall_detektor_main);
        //Prüfen ob Sensor vorhanden ist
        

        final Button btnStart = (Button) findViewById(R.id.btnStart);
        final Button btnStop = (Button) findViewById(R.id.btnStop);
        final ProgressBar progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);

        btnStart.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        	btnStop.setEnabled(true);
        	btnStart.setEnabled(false);
        	progressBar1.setVisibility(1);
    		}
        });
        
        btnStop.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        	btnStop.setEnabled(false);
        	btnStart.setEnabled(true);
        	progressBar1.setVisibility(0);
    		}
        });
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
}
