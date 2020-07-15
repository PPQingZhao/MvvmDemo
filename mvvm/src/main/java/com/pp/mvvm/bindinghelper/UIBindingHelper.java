package com.pp.mvvm.bindinghelper;


import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import com.pp.mvvm.base.BaseLifecycleViewModel;
import com.pp.mvvm.base.IViewBinding;

public class UIBindingHelper<DB extends ViewDataBinding, VM extends BaseLifecycleViewModel> extends ViewBindingHelper<DB, VM> {

    public UIBindingHelper(@NonNull IViewBinding<VM> viewBinding, @NonNull ViewModelProvider provider) {
        super(viewBinding, provider);
    }

    /**
     * 1. 创建 viewModel
     * 2. viewModel 添加生命周期回调
     *
     * @param lifecycle
     * @return
     */
    public VM createLifecyclerModel(@NonNull Lifecycle lifecycle) {
        VM model = createModel();
        lifecycle.addObserver(model);
        return model;
    }

}
