package com.example.mvvmdemo.ui;

import android.app.Application;

import androidx.annotation.NonNull;

import com.pp.mvvm.base.BaseLifecycleViewModel;

public class MainViewModel extends BaseLifecycleViewModel {
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

}
