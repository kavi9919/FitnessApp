package com.example.fitnessapplication;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainScreenViewModel extends ViewModel {
    private MutableLiveData<String> userNameLiveData = new MutableLiveData<>();

    public LiveData<String> getUserNameLiveData() {
        return userNameLiveData;
    }

    // Method to update user name data
    public void updateUserName(String userName) {
        userNameLiveData.setValue(userName);
    }
}
