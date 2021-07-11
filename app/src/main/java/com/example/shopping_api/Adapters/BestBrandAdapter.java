package com.example.shopping_api.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.R;
import com.example.shopping_api.databinding.BrandShopListBinding;
import com.example.shopping_api.moduls.ShopByBrand;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BestBrandAdapter extends RecyclerView.Adapter<BestBrandAdapter.ViewHolder> {

    Context context;
    List<ShopByBrand> list;

    BrandShopListBinding brandShopListBinding;

    public BestBrandAdapter(Context context , List<ShopByBrand> shopByBrands){
        this.context = context;
        this.list = shopByBrands;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        brandShopListBinding = BrandShopListBinding.inflate(layoutInflater , parent, false);

        return new ViewHolder(brandShopListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ShopByBrand shopByBrand = list.get(position);
        String img_url = shopByBrand.getImage();
        final String IMAGE_URL = "https://backendapp.fikrajo.com" + img_url;

        if(img_url.isEmpty()){
            brandShopListBinding.brandImg.setImageResource(R.drawable.ic_arrow_right_alt);
        }else{
            Picasso.with(holder.brandShopListBinding.brandImg.getContext()).load(IMAGE_URL).error(R.drawable.ic_search).
                    into(holder.brandShopListBinding.brandImg);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        BrandShopListBinding brandShopListBinding;
        public ViewHolder(@NonNull BrandShopListBinding itemView){
            super(itemView.getRoot());

            this.brandShopListBinding = itemView;
        }
    }
}
