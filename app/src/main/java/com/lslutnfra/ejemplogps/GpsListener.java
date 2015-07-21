package com.lslutnfra.ejemplogps;

import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class GpsListener extends ActionBarActivity implements LocationListener {
    @Override
    public void onLocationChanged(Location location)
    {
        Log.d("gps","Latitud:"+location.getLatitude());
        Log.d("gps","Long:"+location.getLongitude());
        Log.d("gps","Speed:"+location.getSpeed());
        updato(location);
    }

    private void updato (Location location){

        MainActivity.lon.setText(String.valueOf(location.getLongitude()));
        MainActivity.lat.setText(String.valueOf(location.getLatitude()));
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
