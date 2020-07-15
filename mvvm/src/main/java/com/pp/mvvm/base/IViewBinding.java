package com.pp.mvvm.base;

import android.util.SparseArray;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

public interface IViewBinding<VM extends ViewModel> {

    /**
     * 获取布局资源id
     *
     * @return
     */
    @LayoutRes
    int getLayoutRes();

    /**
     * model class
     *
     * @return
     */
    @NonNull
    Class<VM> getModelClass();

    /**
     * 获取ViewModel 对应的 id  (BR.id)
     *
     * @return
     */
    int getModelVariableId();

    /**
     * 获取binding.setVariable() 集合
     *
     * @return
     */
    SparseArray getVariables();

}
