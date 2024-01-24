package com.example.fitnessapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class LocationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        // Initialize UI elements
        Button buttonBackToMain = findViewById(R.id.buttonBackToMain);

        // Set up button click listener
        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the main screen
                startActivity(new Intent(LocationActivity.this, MainActivity.class));
                finish();
            }
        });

        // Initialize and configure the Google Maps SDK
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                // Configure the map settings, add markers, etc.
                LatLng userLocation = new LatLng(37.7749, -122.4194); // Replace with the actual user's location
                googleMap.addMarker(new MarkerOptions().position(userLocation).title("User Location"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(userLocation));
            }
        });
    }
}
