package com.example.mvvmdemo.ui;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmdemo.BR;
import com.example.mvvmdemo.R;
import com.pp.mvvm.base.BaseVMFragment;
import com.pp.mvvm.bindinghelper.UIBindingHelper;

public class ImageFragment extends BaseVMFragment<ImageBinding, ImageViewModel> {
    @NonNull
    @Override
    protected UIBindingHelper<ImageBinding, ImageViewModel> getViewBindingHelper() {
        return new UIBindingHelper<>(this, ViewModelProviders.of(this));
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_image;
    }

    @NonNull
    @Override
    public Class<ImageViewModel> getModelClass() {
        return ImageViewModel.class;
    }

    @Override
    public int getModelVariableId() {
        return BR.viewModel;
    }

}
