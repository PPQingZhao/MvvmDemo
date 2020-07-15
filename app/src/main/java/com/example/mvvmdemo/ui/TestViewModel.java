package com.example.mvvmdemo.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.pp.mvvm.base.BaseLifecycleViewModel;

public class TestViewModel extends BaseLifecycleViewModel {
    public final MutableLiveData<String> text = new MutableLiveData<>();

    public TestViewModel(@NonNull Application application) {
        super(application);
        text.setValue("wwwwwwww");
    }

}
