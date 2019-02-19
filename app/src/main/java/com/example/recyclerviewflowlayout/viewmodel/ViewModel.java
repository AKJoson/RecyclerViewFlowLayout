package com.example.recyclerviewflowlayout.viewmodel;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.databinding.library.baseAdapters.BR;
import com.example.recyclerviewflowlayout.R;
import com.example.recyclerviewflowlayout.base.BaseAdapter;
import com.example.recyclerviewflowlayout.base.BaseViewHolder;
import com.example.recyclerviewflowlayout.base.BaseViewModel;
import com.example.recyclerviewflowlayout.flexbox.FlexDirection;
import com.example.recyclerviewflowlayout.flexbox.FlexboxLayoutManager;
import com.example.recyclerviewflowlayout.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

public class ViewModel extends BaseViewModel {
    public BaseAdapter<String> adapter;
    public RecyclerView.ItemDecoration itemDecoration;
    public RecyclerView.LayoutManager layoutManager;
    private List<String> list = new ArrayList<>();

    public ViewModel(AppCompatActivity activity) {
        super(activity);
        list.add("我的世界");
        list.add("非请勿进");
        list.add("优雅的谢幕");
        list.add("感谢自己的认真付出");
        list.add("伤口总会痊愈");
        list.add("大舍大得，小舍小得");

        adapter = new BaseAdapter<String>(list, R.layout.item_recycler_layout) {
            @Override
            public void bindBaseViewHolder(BaseViewHolder baseViewHolder, String item, int position) {
                baseViewHolder.getBinding().setVariable(BR.itemValue, item);
                baseViewHolder.getBinding().setVariable(BR.viewModel, ViewModel.this);
                baseViewHolder.getBinding().setVariable(BR.position, position);
                baseViewHolder.getBinding().executePendingBindings();
            }
        };
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(mActivity);
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager = flexboxLayoutManager;
    }

    public void onItemClick(View textView, int position,String item) {
        ((TextView) textView).setSelected(!((TextView) textView).isSelected());
    }

    public void ondeleteClick(View view, int position) {
        adapter.removeOneItem(position);
    }

}
