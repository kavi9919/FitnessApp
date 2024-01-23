package com.example.fitnessapplication;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private TextView textViewFirstName, textViewLastName, textViewEmail, textViewAge, textViewGender;
    private Button buttonRemoveProfile, buttonBackToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewFirstName = findViewById(R.id.textViewFirstName);
        textViewLastName = findViewById(R.id.textViewLastName);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewAge = findViewById(R.id.textViewAge);
        textViewGender = findViewById(R.id.textViewGender);
        buttonRemoveProfile = findViewById(R.id.buttonRemoveProfile);
        buttonBackToMain = findViewById(R.id.buttonBackToMain);

        // Load user profile data and display it
        loadAndDisplayUserProfile();
        List<UsersDTO> usersDTOList = new ArrayList<>();
        OrmliteHelper ormliteHelper = new OrmliteHelper(this);
        try {
            usersDTOList = ormliteHelper.getAll(UsersDTO.class);
        } catch (SQLException | java.sql.SQLException e) {
            throw new RuntimeException(e);
        }
        loadAndDisplayUserProfile(usersDTOList.get(usersDTOList.size() - 1));
    loadAndDisplayUserProfile();
        buttonRemoveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement SQLite database deletion logic here
                // Remove the user profile from the database

                // After removing, navigate back to the main activity
                finish();
            }
        });

        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the main activity
                finish();
            }
        });

    }
    private void loadAndDisplayUserProfile(UsersDTO user) {
        long userId = user.getId();
        // Check if the user ID is valid
        if (userId >= 0 ) {

            // Set user data to TextViews
            textViewFirstName.setText("First Name: " + user.getFirstname());
            textViewLastName.setText("Last Name: " + user.getLastname());
            textViewEmail.setText("Email: " + user.getEmail());
            textViewAge.setText("Age: " + user.getAge());
            textViewGender.setText("Gender: " + (user.isGender() ? "Male" : "Female"));
        } else {
            // Handle invalid user ID or other error condition
            // You may show an error message or take appropriate action
        }
    }

    private void loadAndDisplayUserProfile() {
        // Implement SQLite database retrieval logic here
        // Get the user profile details from the database and display them
        long userId = 1; // Replace with the actual user ID
//        DatabaseHelper dbHelper = new DatabaseHelper(this);
//        Cursor cursor = dbHelper.getUserProfileById(userId);

//        if (cursor.moveToFirst()) {
//            @SuppressLint("Range") String firstName = cursor.getString(cursor.getColumnIndex("first_name"));
//            @SuppressLint("Range") String lastName = cursor.getString(cursor.getColumnIndex("last_name"));
//            @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex("email"));
//            @SuppressLint("Range") int age = cursor.getInt(cursor.getColumnIndex("age"));
//            @SuppressLint("Range") String gender = cursor.getString(cursor.getColumnIndex("gender"));

//            textViewFirstName.setText("First Name: " + firstName);
//            textViewLastName.setText("Last Name: " + lastName);
//            textViewEmail.setText("Email: " + email);
//            textViewAge.setText("Age: " + age);
//            textViewGender.setText("Gender: " + gender);
//        }

//        cursor.close();
//        dbHelper.close();
    }
}
