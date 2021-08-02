/*
package com.example.shopping_api.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.databinding.ShortDiscBinding;
import com.example.shopping_api.moduls.BigVariation;
import com.example.shopping_api.moduls.DetailedProduct;
import com.example.shopping_api.moduls.ProductInfo;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ShortDiscAdapter extends RecyclerView.Adapter<ShortDiscAdapter.ViewHolder>{


    List<ProductInfo> list;
    ShortDiscBinding binding;

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = ShortDiscBinding.inflate(layoutInflater , parent , false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        ProductInfo productInfo = list.get(position);
        holder.bind(productInfo);
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public void setPrice(List<ProductInfo> productInfo){
        this.list = productInfo;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ShortDiscBinding shortDiscBinding;

        public ViewHolder(@NonNull ShortDiscBinding itemView){
            super(itemView.getRoot());
            this.shortDiscBinding = itemView;
        }

        public void bind(ProductInfo productInfo){
            String title = productInfo.getTitle();
            String shortDis = productInfo.getShortDesc();
            boolean isOld = productInfo.bigVariation().get(0).getVariations().get(0).isIs_old();
            String oldPrice = productInfo.getBigVariation().get(0).getVariations().get(0).getOld_price();
            String orgPrice = productInfo.getBigVariation().get(0).getVariations().get(0).getPrice();
            String color = productInfo.getBigVariation().get(0).getColor();
            int textColor = Color.parseColor(color);

            binding.title.setText(title);
            binding.shortDisc.setText(shortDis);

            if(isOld){
                binding.oldPrice.setText(oldPrice);
                binding.oldPrice.setPaintFlags(binding.oldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                binding.oldPrice.setTextColor(textColor);
            }

            binding.orginPrice.setText(orgPrice);
        }
    }
}
*/
