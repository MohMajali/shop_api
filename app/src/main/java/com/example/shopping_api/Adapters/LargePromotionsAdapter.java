package com.example.shopping_api.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.R;
import com.example.shopping_api.databinding.LargPromsListBinding;
import com.example.shopping_api.moduls.LargePromotion;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LargePromotionsAdapter extends RecyclerView.Adapter<LargePromotionsAdapter.ViewHolder> {

    Context context;
    List<LargePromotion> list;

    LargPromsListBinding listBinding;
    public LargePromotionsAdapter(Context context , List<LargePromotion> largePromotions){
       this.context = context;
       this.list = largePromotions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        listBinding = LargPromsListBinding.inflate(layoutInflater , parent , false);
        return new ViewHolder(listBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LargePromotion largePromotion = list.get(position);

        String img_url = largePromotion.getImage();
        final String IMAGE_URL = "https://backendapp.fikrajo.com" + img_url;

       if(largePromotion.getImage().isEmpty()){
           listBinding.largeProms.setImageResource(R.drawable.ic_shopping_cart);
       } else {
           Picasso.with(holder.largPromsListBinding.largeProms.getContext()).load(IMAGE_URL).error(R.drawable.ic_search).into(holder.largPromsListBinding.largeProms);
       }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder  extends  RecyclerView.ViewHolder{
        LargPromsListBinding largPromsListBinding;
        public ViewHolder(@NonNull LargPromsListBinding itemView) {
            super(itemView.getRoot());
            this.largPromsListBinding = itemView;
        }
    }
}

