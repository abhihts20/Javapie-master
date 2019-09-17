package com.miniproject.javapie.ui.registered_events;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegisteredEventsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RegisteredEventsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is registered fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}