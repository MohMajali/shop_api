package com.example.shopping_api.moduls;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.Adapters.OptionsAdapter;
import com.example.shopping_api.databinding.SizeListBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.ViewHolder> {

    Context context;
    SizeListBinding listBinding;
    List<Variation> list;

    Variation variation;

    OptionsAdapter optionsAdapter;

    public SizeAdapter(){}

    public SizeAdapter(Context context , List<Variation> variationList){
        this.context = context;
        this.list = variationList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        listBinding = SizeListBinding.inflate(layoutInflater , parent , false);

        return new ViewHolder(listBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        variation = list.get(position);
        String size = variation.getSize();
        listBinding.size.setText(size);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        SizeListBinding sizeListBinding;

        public ViewHolder(@NonNull SizeListBinding itemView){
            super(itemView.getRoot());
            this.sizeListBinding = itemView;
        }
    }
}
