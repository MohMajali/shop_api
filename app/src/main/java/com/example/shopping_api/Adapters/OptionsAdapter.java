package com.example.shopping_api.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shopping_api.ProductDetails.OnClick;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.OptionsListBinding;
import com.example.shopping_api.moduls.BigVariation;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.ViewHolder>{

    List<BigVariation> list;
    OptionsListBinding binding;
    OnClick onClickItem;


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = OptionsListBinding.inflate(layoutInflater , parent , false);
        return new ViewHolder(binding, onClickItem);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        BigVariation bigVariation = list.get(position);

        holder.bing(bigVariation);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.options_list;
    }

    public BigVariation getBigVariation(int position){
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public void setColorClickListener(OnClick onClickItem){
        this.onClickItem = onClickItem;
    }



    public  void setBigVariation(List<BigVariation> list)
    {
        this.list=list;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        OptionsListBinding optionsListBinding;
        OnClick onClickItem;

        public ViewHolder(@NonNull OptionsListBinding optionsListBinding , OnClick onClickItem) {
            super(optionsListBinding.getRoot());

            this.optionsListBinding = optionsListBinding;
            this.onClickItem = onClickItem;

            itemView.setOnClickListener(this);
        }

        public void bing(BigVariation bigVariation){
            String colorString = bigVariation.getColor();
            int color = Color.parseColor(colorString);

            optionsListBinding.imgColor.setBackgroundColor(color);
        }

        @Override
        public void onClick(View v) {
            if(onClickItem != null){
                if(getAdapterPosition() != -1){
                    onClickItem.onClickListener(new OptionsAdapter() , getAdapterPosition());
                }
            }
        }
    }
}
