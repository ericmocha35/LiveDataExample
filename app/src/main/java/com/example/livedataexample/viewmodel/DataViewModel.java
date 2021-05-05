package com.example.livedataexample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {

    private MutableLiveData<Integer> mLikeCount = new MutableLiveData<>();

    public DataViewModel() {
        mLikeCount.setValue(0);
    }

    public void onLike() {
        mLikeCount.setValue(mLikeCount.getValue() + 1);
    }

    public void onReset() {
        mLikeCount.setValue(0);
    }

    public LiveData<Integer> getLikeCount() {
        return mLikeCount;
    }
}
