package com.example.mvvmdemo.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmdemo.R;
import com.pp.mvvm.base.BaseLifecycleViewModel;

public class ImageViewModel extends BaseLifecycleViewModel {
    public final MutableLiveData<Integer> image = new MutableLiveData<>();

    public ImageViewModel(@NonNull Application application) {
        super(application);
        image.setValue(R.drawable.ic_launcher_background);
    }

}
