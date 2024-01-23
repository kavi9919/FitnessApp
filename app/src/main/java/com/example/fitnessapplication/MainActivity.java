package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
public class MainActivity extends AppCompatActivity {

    private MainScreenViewModel mainScreenViewModel;
    private MainScreenRepository mainScreenRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainScreenRepository = new MainScreenRepository(this);

        mainScreenViewModel = new ViewModelProvider(this).get(MainScreenViewModel.class);

        // Observe changes in user name LiveData
        mainScreenViewModel.getUserNameLiveData().observe(this, userName -> {
            TextView textViewUserName = findViewById(R.id.textViewUserName);
            textViewUserName.setText("Welcome, " + userName);
        });

        // Set initial user name
        String initialUserName = mainScreenRepository.getUserName();
        mainScreenViewModel.updateUserName(initialUserName);

        // Set up button click listeners
        Button buttonSeeProfile = findViewById(R.id.buttonSeeProfile);
        buttonSeeProfile.setOnClickListener(v -> {
            // Start the ProfileActivity
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        });


        Button buttonLocateYourself = findViewById(R.id.buttonLocateYourself);
        Button buttonStepCounter = findViewById(R.id.buttonStepCounter);

        // Your button click logic goes here...
    }
}