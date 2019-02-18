package com.example.recyclerviewflowlayout.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    private List<T> listData;
    private int layoutId;

    public BaseAdapter(List<T> listData, int layoutId) {
        this.listData = listData;
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BaseViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int position) {
        bindBaseViewHolder(baseViewHolder, position);
    }
    public abstract void bindBaseViewHolder(BaseViewHolder baseViewHolder, int position);

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void addData(List<T> list) {
        listData.addAll(list);
        notifyDataSetChanged();
    }
    public void updateData(List<T> list){
        listData.clear();
        listData.addAll(list);
        notifyDataSetChanged();
    }
    //you can add some method to Delete or Add some refer position.

}
