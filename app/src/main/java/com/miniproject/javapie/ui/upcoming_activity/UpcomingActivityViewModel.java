package com.miniproject.javapie.ui.upcoming_activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UpcomingActivityViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UpcomingActivityViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is upcoming fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}