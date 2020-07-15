package com.example.mvvmdemo.ui;

import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmdemo.BR;
import com.example.mvvmdemo.R;
import com.pp.mvvm.base.BaseVMFragment;
import com.pp.mvvm.bindinghelper.UIBindingHelper;

public class TestFragment extends BaseVMFragment<TestBinding, TestViewModel> {
    @NonNull
    @Override
    protected UIBindingHelper<TestBinding, TestViewModel> getViewBindingHelper() {
        return new UIBindingHelper<>(this, ViewModelProviders.of(this));
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_test;
    }

    @NonNull
    @Override
    public Class<TestViewModel> getModelClass() {
        return TestViewModel.class;
    }

    @Override
    public int getModelVariableId() {
        return BR.viewModel;
    }

}
