package com.example.mvvmdemo.ui;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.databinding.MainBinding;
import com.pp.mvvm.base.BaseVMActivity;
import com.pp.mvvm.bindinghelper.UIBindingHelper;


public class MainActivity extends BaseVMActivity<MainBinding, MainViewModel> {

    private NavController mNavController;

    @NonNull
    @Override
    protected UIBindingHelper<MainBinding, MainViewModel> getViewBindingHelper() {
        return new UIBindingHelper<>(this, ViewModelProviders.of(this));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNavController = Navigation.findNavController(this, R.id.main_fragment);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @NonNull
    @Override
    public Class<MainViewModel> getModelClass() {
        return MainViewModel.class;
    }

    @Override
    public int getModelVariableId() {
        return BR.viewModel;
    }


    public void onAction(View view) {
        if (mNavController.getCurrentDestination().getId() == R.id.nav_testFragment) {
            mNavController.navigate(R.id.action_test_to_image);
        } else {
            mNavController.navigate(R.id.action_image_to_test);
        }
    }

}
