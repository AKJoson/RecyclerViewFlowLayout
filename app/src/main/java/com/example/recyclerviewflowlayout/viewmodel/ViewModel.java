package com.example.recyclerviewflowlayout.viewmodel;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.example.recyclerviewflowlayout.R;
import com.example.recyclerviewflowlayout.base.BaseAdapter;
import com.example.recyclerviewflowlayout.base.BaseViewHolder;
import com.example.recyclerviewflowlayout.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class ViewModel extends BaseViewModel {
    public BaseAdapter<String> adapter;
    public RecyclerView.ItemDecoration itemDecoration;
    public RecyclerView.LayoutManager layoutManager;
    private List<String> list = new ArrayList<>();

    public ViewModel(AppCompatActivity activity) {
        super(activity);
        for (int i = 0; i < 10; i++) {
            list.add("data:" + i);
        }

        adapter = new BaseAdapter<String>(new ArrayList<String>(), R.layout.item_recycler_layout) {
            @Override
            public void bindBaseViewHolder(BaseViewHolder baseViewHolder, int position) {
                baseViewHolder.getBinding().setVariable(BR.itemValue, list.get(position));
                baseViewHolder.getBinding().setVariable(BR.viewModel, ViewModel.this);
                baseViewHolder.getBinding().setVariable(BR.position, position);
                baseViewHolder.getBinding().executePendingBindings();
            }
        };
        adapter.addData(list);
        layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
    }

    public void onItemClick(View textView, int position) {
        ((TextView)textView).setSelected(!((TextView)textView).isSelected());
    }

}
