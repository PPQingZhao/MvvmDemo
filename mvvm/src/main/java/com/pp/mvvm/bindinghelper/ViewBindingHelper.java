package com.pp.mvvm.bindinghelper;

import android.util.SparseArray;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.pp.mvvm.base.IViewBinding;

public class ViewBindingHelper<DB extends ViewDataBinding, VM extends ViewModel> {

    private final ViewModelProvider mViewModelProvider;
    private final IViewBinding<VM> mViewBinding;

    public ViewBindingHelper(@NonNull IViewBinding<VM> viewBinding, @NonNull ViewModelProvider provider) {
        this.mViewBinding = viewBinding;
        this.mViewModelProvider = provider;
    }

    /**
     * 1. 创建 viewModel
     *
     * @return
     */
    public VM createModel() {
        VM model = mViewModelProvider.get(mViewBinding.getModelClass());
        return model;
    }

    /**
     * 1.创建 databinding
     * 2.binding 绑定 model
     *
     * @param inflater
     * @return
     */
    public DB createBinding(@NonNull LayoutInflater inflater) {
        // 设置布局文件,初始化databinding
        DB binding = DataBindingUtil.inflate(inflater, mViewBinding.getLayoutRes(), null, false);
        bindModel(binding);
        bindVariables(binding);
        return binding;
    }

    public void bindModel(DB binding) {
        // databinbding 设置 ViewModel
        binding.setVariable(mViewBinding.getModelVariableId(), createModel());
    }

    public void bindVariables(DB binding) {
        // 获取 mBinding.setVariable 集合
        SparseArray variablesMap = mViewBinding.getVariables();
        if (null != variablesMap) {
            int size = variablesMap.size();
            for (int i = 0; i < size; i++) {
                binding.setVariable(variablesMap.keyAt(i), variablesMap.valueAt(i));
            }
        }
    }

}
