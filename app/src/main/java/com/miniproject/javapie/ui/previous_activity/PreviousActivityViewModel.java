package com.miniproject.javapie.ui.previous_activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PreviousActivityViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PreviousActivityViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is previous fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}