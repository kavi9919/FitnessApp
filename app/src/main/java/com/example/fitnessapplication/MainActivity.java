package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainScreenViewModel mainScreenViewModel;
    private MainScreenRepository mainScreenRepository;
    private OrmliteHelper ormliteHelper;
    private UsersDTO user = new UsersDTO();
    private FitnessDTO fitnessDTO = new FitnessDTO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainScreenRepository = new MainScreenRepository(this);

        mainScreenViewModel = new ViewModelProvider(this).get(MainScreenViewModel.class);

        // Observe changes in user name LiveData
        mainScreenViewModel.getUserNameLiveData().observe(this, userName -> {
            TextView textViewUserName = findViewById(R.id.textViewUserName);
            List<UsersDTO> usersDTOList = new ArrayList<>();
            ormliteHelper = new OrmliteHelper(this);
            try {
                usersDTOList = ormliteHelper.getAll(UsersDTO.class);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
                        textViewUserName.setText("Welcome, " +usersDTOList.get(usersDTOList.size() -1 ).getFirstname() );
        });

        // Set initial user name
        String initialUserName = mainScreenRepository.getUserName();
        mainScreenViewModel.updateUserName(initialUserName);

        // Set up button click listeners
        Button buttonSeeProfile = findViewById(R.id.buttonSeeProfile);
        buttonSeeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });



        Button buttonLocateYourself = findViewById(R.id.buttonLocateYourself);
        Button buttonStepCounter = findViewById(R.id.buttonStepCounter);
        buttonStepCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StepCounter.class);
                startActivity(intent);
            }
        });
        buttonLocateYourself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, YourSelf.class);
                startActivity(intent);
            }
        });


    }
}