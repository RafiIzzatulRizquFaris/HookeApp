package com.example.hookeapplication.ui.parallel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ParallelViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ParallelViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}