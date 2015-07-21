package com.lslutnfra.ejemplogps;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity  implements DialogInterface.OnClickListener,View.OnClickListener {

    private LocationManager locManager;
    private boolean flagActivarGps;
    public static TextView lon = null;
    public static TextView lat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener miLocListener = new GpsListener();
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 1, miLocListener);
        flagActivarGps = false;

        lon = (TextView) this.findViewById(R.id.textViewLong);
        lat = (TextView) this.findViewById(R.id.textViewLat);

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)==false && flagActivarGps==false)
        {
            DialogoGPS dialog = new DialogoGPS(this);
            dialog.show(getFragmentManager(), "dialogo");
            flagActivarGps=true;
        }
    }

    @Override
    public void onClick(DialogInterface arg0, int arg1) {
        Intent i = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

       /* if (v.getId() == R.id.button)
        {
            GpsListener gps = new GpsListener();
            TextView lon = (TextView) findViewById(R.id.textViewLong);
            TextView lat = (TextView) findViewById(R.id.textViewLat);
            lon.setText("" + gps.getLon());
            lat.setText("" + gps.getLat());
        }*/

    }
}
