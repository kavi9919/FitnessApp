package com.example.fitnessapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class UserRegistrationActivity  extends AppCompatActivity {

    private EditText editTextEmail, editTextFirstName, editTextLastName, editTextAge;
    private RadioGroup radioGroupGender;
    private Button buttonSaveProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextAge = findViewById(R.id.editTextAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        buttonSaveProfile = findViewById(R.id.buttonSaveProfile);

        buttonSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserProfile();
            }
        });
    }

    private void saveUserProfile() {
        // Implement SQLite database insertion logic here
        // Create a new UserProfile object and insert it into the database

        // After saving, navigate to the profile display activity
        Intent intent = new Intent(UserRegistrationActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}
