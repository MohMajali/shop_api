package com.example.shopping_api.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.databinding.OptionsListBinding;
import com.example.shopping_api.moduls.BigVariation;
import com.example.shopping_api.moduls.SizeAdapter;
import com.example.shopping_api.moduls.Variation;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.ViewHolder>{

    Context context;
    List<BigVariation> list;
    OptionsListBinding binding;
    List<Variation> variationList;

    String id;

    SizeAdapter sizeAdapter;

    public OptionsAdapter(){}

    public OptionsAdapter(Context context , List<BigVariation> vairations){
        this.context = context;
        this.list = vairations;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = OptionsListBinding.inflate(layoutInflater , parent , false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        BigVariation bigVariation = list.get(position);

        String color = bigVariation.getColor();
        int imgColor = Color.parseColor(color);

        String varColor = bigVariation.getVariations().get(0).getColor();
        int smallVarColor = Color.parseColor(varColor);

        id = bigVariation.getVariations().get(0).getId();

        binding.imgColor.setBackgroundColor(imgColor);
        binding.imgColor.setOnClickListener(v -> {

            if(smallVarColor == imgColor){
                sizeAdapter = new SizeAdapter();

                //Options adapter
                notifyDataSetChanged();
                //Size adapter

                sizeAdapter.notifyDataSetChanged();
            } else {}
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        OptionsListBinding optionsListBinding;

        public ViewHolder(@NonNull OptionsListBinding itemView) {
            super(itemView.getRoot());
            this.optionsListBinding = itemView;
        }
    }
}
