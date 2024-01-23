package com.example.fitnessapplication;
import android.content.Context;
import android.content.SharedPreferences;

public class MainScreenRepository {
    private static final String PREF_NAME = "user_profile";
    private static final String KEY_USER_NAME = "userName";

    private SharedPreferences sharedPreferences;

    public MainScreenRepository(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    // Method to get user name from SharedPreferences
    public String getUserName() {
        return sharedPreferences.getString(KEY_USER_NAME, "User");
    }
}
