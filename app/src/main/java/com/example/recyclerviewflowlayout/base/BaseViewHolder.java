package com.example.recyclerviewflowlayout.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public ViewDataBinding getBinding() {
        if (binding == null)
            throw new RuntimeException("BaseViewModel binding view maybe has mistake");
        return binding;
    }
}
