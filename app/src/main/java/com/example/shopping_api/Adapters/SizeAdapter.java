package com.example.shopping_api.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shopping_api.ProductDetails.OnClick;
import com.example.shopping_api.databinding.SizeListBinding;
import com.example.shopping_api.moduls.Feed;
import com.example.shopping_api.moduls.Variation;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.ViewHolder> {

    SizeListBinding listBinding;
    List<Variation> list;
    OnClick onClickItem;
    Variation variation;
    public int selectedPosition = -1;


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
        holder.bind(variation , selectedPosition);
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public void setNewSize(List<Variation> variationList){
        this.list = variationList;
        notifyDataSetChanged();

    }

    public void onclickItemListen(OnClick onClickItem){
        this.onClickItem = onClickItem;
    }

    public Variation getVariation(int position){
        return list.get(position);
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

        public void bind(Variation variation , int selectedPosition){
            int color = Color.parseColor("#9c093a");
            int color2 = Color.parseColor("#808080");
            String size = variation.getSize();
            sizeListBinding.size.setText(size);

            if(selectedPosition == -1){
                sizeListBinding.size.setTextColor(color);
            } else if(selectedPosition == getAdapterPosition()){
                sizeListBinding.size.setTextColor(color);
            } else {
                sizeListBinding.size.setTextColor(color2);
                Log.i("position" , String.valueOf(selectedPosition));
            }

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
