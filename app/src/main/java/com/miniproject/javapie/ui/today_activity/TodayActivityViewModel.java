package com.miniproject.javapie.ui.today_activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TodayActivityViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TodayActivityViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is today fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}