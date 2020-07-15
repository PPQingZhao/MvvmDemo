package com.pp.mvvm.base;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;

import com.pp.mvvm.bindinghelper.UIBindingHelper;

public abstract class BaseVMActivity<DB extends ViewDataBinding, VM extends BaseLifecycleViewModel> extends AppCompatActivity implements IViewBinding<VM> {
    protected DB mBinding;
    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UIBindingHelper<DB, VM> bindingHelper = getViewBindingHelper();
        // 创建viewModel
        mViewModel = bindingHelper.createLifecyclerModel(getLifecycle());
        mViewModel.event.observe(this, new Observer<ViewEvent>() {
            @Override
            public void onChanged(ViewEvent viewEvent) {
                handleEvent(viewEvent);
            }
        });
        // databinding
        mBinding = bindingHelper.createBinding(LayoutInflater.from(this));
        setContentView(mBinding.getRoot());
    }

    protected void handleEvent(ViewEvent viewEvent) {

    }

    protected abstract @NonNull
    UIBindingHelper<DB, VM> getViewBindingHelper();

    @Override
    public SparseArray getVariables() {
        return null;
    }
}
