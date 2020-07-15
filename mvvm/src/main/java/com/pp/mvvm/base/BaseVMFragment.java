package com.pp.mvvm.base;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.pp.mvvm.bindinghelper.UIBindingHelper;

public abstract class BaseVMFragment<DB extends ViewDataBinding, VM extends BaseLifecycleViewModel> extends Fragment implements IViewBinding<VM> {

    protected VM mViewModel;
    private UIBindingHelper<DB, VM> mConfig;
    protected DB mBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mConfig = getViewBindingHelper();
        mViewModel = mConfig.createLifecyclerModel(getLifecycle());
    }

    protected void handleEvent(ViewEvent viewEvent) {
        if (getActivity() instanceof BaseVMActivity) {
            ((BaseVMActivity) getActivity()).handleEvent(viewEvent);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = mConfig.createBinding(inflater);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.event.observe(getViewLifecycleOwner(), new Observer<ViewEvent>() {
            @Override
            public void onChanged(ViewEvent viewEvent) {
                handleEvent(viewEvent);
            }
        });
    }

    protected abstract @NonNull
    UIBindingHelper<DB, VM> getViewBindingHelper();

    @Override
    public SparseArray getVariables() {
        return null;
    }
}
