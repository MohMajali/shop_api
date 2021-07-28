package com.example.shopping_api.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shopping_api.ProductDetails.OnClick;
import com.example.shopping_api.databinding.SizeListBinding;
import com.example.shopping_api.moduls.Variation;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.ViewHolder> {

    Context context;
    SizeListBinding listBinding;
    List<Variation> list;
    OnClick onClickItem;
    Variation variation;

    public SizeAdapter(){}

    public SizeAdapter(Context context , List<Variation> variationList, OnClick onClickItem){
        this.context = context;
        this.list = variationList;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        listBinding = SizeListBinding.inflate(layoutInflater , parent , false);

        return new ViewHolder(listBinding, onClickItem);
    }

    private static final String TAG = "SizeAdapter";
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        variation = list.get(position);
        String size = variation.getSize();
        Log.e(TAG, "onBindViewHolder: "+size );
        listBinding.size.setText(size);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setNewSize(List<Variation> variationList){
        this.list = variationList;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        SizeListBinding sizeListBinding;
        OnClick onClickItem;

        public ViewHolder(@NonNull SizeListBinding sizeListBinding , OnClick onClickItem) {
            super(sizeListBinding.getRoot());
            this.sizeListBinding = sizeListBinding;
            this.onClickItem = onClickItem;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onClickItem != null){
                if(getAdapterPosition() != -1){
                    onClickItem.onClickListener(new SizeAdapter() , getAdapterPosition());
                }
            }
        }
    }
}
