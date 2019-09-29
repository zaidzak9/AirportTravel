package com.zaid.airporttravel.presentation

import android.Manifest
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.zaid.airporttravel.utility.SectionsPagerAdapter
import android.content.pm.PackageManager
import android.Manifest.permission
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.libraries.places.api.Places
import com.zaid.airporttravel.R
import com.zaid.airporttravel.domain.PlacesApiDomain


class MainActivity : AppCompatActivity() {
    var locationManager: LocationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        // Initialize the SDK
        Places.initialize(applicationContext, R.string.GOOGLE_PLACE_API_KEY.toString())

// Create a new Places client instance
        val placesClient = Places.createClient(this)


        getCuurentLocation()

    }

    fun getCuurentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT)

            locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?;
            try {
                // Request location updates
                locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0f, locationListener);
            } catch (ex: SecurityException) {
                Log.d("zzzz ", "Security Exception, no location available");
            }
        } else {
            // Permission is missing and must be requested.
            val permissions = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
            ActivityCompat.requestPermissions(this, permissions, 0)
        }
    }

    //define the listener
    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            System.out.println("zzzz " + location.longitude + ":" + location.latitude);
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }

    fun getPlacesApiData(){

        val placesApiDomain:PlacesApiDomain? = null

        var map:Map<String,String>

        placesApiDomain?.getBitcoinChartData()
    }
}