package com.example.recyclerviewflowlayout;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerviewflowlayout.databinding.ActivityMainBinding;
import com.example.recyclerviewflowlayout.viewmodel.ViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new ViewModel(this));
    }

    @BindingAdapter(value = {"adapter", "itemDecoration", "layoutManager"}, requireAll = false)
    public static void setRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter, RecyclerView.ItemDecoration itemDecoration, RecyclerView.LayoutManager layoutManager) {
        if (recyclerView != null) {
            if (adapter != null) {
                recyclerView.setAdapter(adapter);
            }
            if (recyclerView.getItemDecorationCount() == 0 && itemDecoration != null) {
                //make sure itemDecoration just add once.if you add twice ,the distance will add.
                recyclerView.addItemDecoration(itemDecoration);
            }
            if (layoutManager != null) {
                recyclerView.setLayoutManager(layoutManager);
            }
        }
    }
}
