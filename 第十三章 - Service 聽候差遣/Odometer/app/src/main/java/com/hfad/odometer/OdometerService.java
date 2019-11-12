package com.hfad.odometer;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.RequiresApi;

public class OdometerService extends Service
{
    private final IBinder binder = new OdometerBinder();
    private static double distanceInMeters;
    private static Location lastLocation = null;
    private LocationListener listener;
    private LocationManager locManager;

    public class OdometerBinder extends Binder
    {
        OdometerService getOdometer()
        {
            return OdometerService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return binder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate()
    {
        listener = new LocationListener()
        {
            @Override
            public void onLocationChanged(Location location)
            {
                if (lastLocation == null)
                {
                    lastLocation = location;
                }
                distanceInMeters += location.distanceTo(lastLocation);
                lastLocation = location;
            }

            @Override
            public void onProviderDisabled(String arg0)
            {

            }

            @Override
            public void onProviderEnabled(String arg0)
            {

            }

            @Override
            public void onStatusChanged(String arg0, int arg1, Bundle bundle)
            {

            }
        };

        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, listener);
    }

    @Override
    public void onDestroy()
    {
        if (locManager != null && listener != null)
        {
            locManager.removeUpdates(listener);
            locManager = null;
            listener = null;
        }
    }

    public double getMiles()
    {
        return this.distanceInMeters / 1609.344;
    }
}
