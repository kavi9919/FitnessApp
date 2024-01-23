package com.example.fitnessapplication;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private static final String PREF_NAME = "user_profile";
    private static final String KEY_PROFILE_REGISTERED = "profile_registered";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Check if the user's profile is registered
        SharedPreferences preferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        boolean isProfileRegistered = preferences.getBoolean(KEY_PROFILE_REGISTERED, false);

        // Initialize UI elements
        ImageView imageViewLogo = findViewById(R.id.imageViewLogo);

        // Optional: Apply animation to the logo
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        imageViewLogo.startAnimation(animation);

        // Delay for 2 seconds and then navigate to the next screen
        new Handler().postDelayed(() -> {
            if (isProfileRegistered) {
                startMainActivity();
            } else {
                startUserRegistrationActivity();
            }
        }, 2000);
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void startUserRegistrationActivity() {
        Intent intent = new Intent(this, UserRegistrationActivity.class);
        startActivity(intent);
        finish();
    }
}
