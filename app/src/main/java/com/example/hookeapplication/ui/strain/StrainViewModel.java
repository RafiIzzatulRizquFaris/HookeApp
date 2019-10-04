package com.example.hookeapplication.ui.strain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StrainViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StrainViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Strain Formula");
    }

    public LiveData<String> getText() {
        return mText;
    }
}