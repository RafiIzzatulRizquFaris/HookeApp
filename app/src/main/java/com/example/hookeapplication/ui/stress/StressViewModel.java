package com.example.hookeapplication.ui.stress;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StressViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StressViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Stress Formula");
    }

    public LiveData<String> getText() {
        return mText;
    }
}