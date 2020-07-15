package com.pp.mvvm.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.DefaultLifecycleObserver;

import com.pp.mvvm.lifecycle.SingleLiveEvent;

public abstract class BaseLifecycleViewModel extends AndroidViewModel implements DefaultLifecycleObserver {
    final SingleLiveEvent<ViewEvent> event = new SingleLiveEvent<>();

    public BaseLifecycleViewModel(@NonNull Application application) {
        super(application);
    }

}
