package com.example.hookeapplication.ui.modulus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ModulusViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ModulusViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Modulus Formula");
    }

    public LiveData<String> getText() {
        return mText;
    }
}