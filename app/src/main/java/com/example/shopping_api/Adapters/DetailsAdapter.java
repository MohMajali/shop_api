/*
package com.example.shopping_api.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.databinding.DetailsListBinding;
import com.example.shopping_api.databinding.ShortDiscBinding;
import com.example.shopping_api.moduls.ProductInfo;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {

    Context context;
    List<ProductInfo> list;

    DetailsListBinding binding;

    public DetailsAdapter(Context context , List<ProductInfo> productInfo){
        this.context = context;
        this.list = productInfo;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = DetailsListBinding.inflate(layoutInflater , parent , false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        ProductInfo productInfo = list.get(position);

        String details = productInfo.getDetails();

        binding.detailsTxt.setText(details);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        DetailsListBinding detailsListBinding;

        public ViewHolder(@NonNull DetailsListBinding itemView){
            super(itemView.getRoot());
            this.detailsListBinding = itemView;
        }
    }
}
*/
