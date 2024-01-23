package com.example.fitnessapplication;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLException;

public class UserRegistrationActivity extends AppCompatActivity {

    private static final String KEY_PROFILE_REGISTERED = "profile_registered";
    private EditText editTextEmail, editTextFirstName, editTextLastName, editTextAge;
    private RadioGroup radioGroupGender;
    private Button buttonSaveProfile;
    private OrmliteHelper ormliteHelper;

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
        ormliteHelper = new OrmliteHelper(this);

        buttonSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserProfile();
            }
        });
    }

    private void saveUserProfile() {
        // Get values from EditText fields
        String email = editTextEmail.getText().toString().trim();
        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();

        // Get selected gender from RadioGroup
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        boolean isMale = getGender(selectedGenderId);

        // Validate that all fields are not null and not empty
        if (isValidField(email) && isValidField(firstName) && isValidField(lastName) && isValidField(age)) {
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setEmail(email);
            usersDTO.setAge(Integer.parseInt(age));
            usersDTO.setLastname(lastName);
            usersDTO.setFirstname(firstName);
            usersDTO.setGender(isMale); // Assuming there's a method like setMale in your UsersDTO class

            try {
                ormliteHelper.createOrUpdate(usersDTO);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                ormliteHelper.createOrUpdate(usersDTO);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            SharedPreferences preferences = getSharedPreferences("MyPreferences",MODE_PRIVATE);

// Get SharedPreferences editor
            SharedPreferences.Editor editor = preferences.edit();

// Set the boolean value for KEY_PROFILE_REGISTERED
            editor.putBoolean(KEY_PROFILE_REGISTERED, true); // true or false, depending on your requirement

// Apply the changes
            editor.apply();

            Intent intent = new Intent(UserRegistrationActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            // If any field is invalid, show a message or handle it accordingly
            // For example, you can display a Toast message
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        }
    }

    // Helper method to check if a field is valid
    private boolean isValidField(String fieldValue) {
        return fieldValue != null && !fieldValue.isEmpty();
    }

    // Helper method to get the selected gender based on radio button ID
    private boolean getGender(int selectedGenderId) {
        if (selectedGenderId == R.id.radioButtonMale) {
            return true;
        } else if (selectedGenderId == R.id.radioButtonFemale) {
            return false;
        } else {
            return false; // Default value or handle the case accordingly
        }
    }

}
