package com.example.shopping_api.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.R;
import com.example.shopping_api.databinding.BestSellingListBinding;
import com.example.shopping_api.moduls.BestSelling;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BestSellingAdapter extends RecyclerView.Adapter<BestSellingAdapter.ViewHolder> {

    Context context;
    List<BestSelling> list;

    BestSellingListBinding bestSellingListBinding;

    public BestSellingAdapter(Context context , List<BestSelling> bestSellings){
        this.context = context;
        this.list = bestSellings;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        bestSellingListBinding = BestSellingListBinding.inflate(layoutInflater , parent , false);
        return new ViewHolder(bestSellingListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BestSelling bestSelling = list.get(position);

        String img_url = bestSelling.getImage();
        final String IMAGE_URL = "https://backendapp.fikrajo.com" + img_url;
        String title = bestSelling.getTitle();
        boolean isOld = bestSelling.isIs_old();
        String oldPrice = bestSelling.getOld_price();
        String price = bestSelling.getPrice();

        if(img_url.isEmpty()){
            bestSellingListBinding.bestImg.setImageResource(R.drawable.ic_arrow_right_alt);
        } else {
            Picasso.with(holder.bestSellingListBinding.bestImg.getContext()).load(IMAGE_URL).error(R.drawable.ic_search).
                    into(holder.bestSellingListBinding.bestImg);
        }

        bestSellingListBinding.titleBest.setText(title);

        if(isOld){
            bestSellingListBinding.oldBest.setText(oldPrice);
            bestSellingListBinding.oldBest.setPaintFlags(bestSellingListBinding.oldBest.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }


        bestSellingListBinding.priceBest.setText(price);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        BestSellingListBinding bestSellingListBinding;
        public ViewHolder(@NonNull BestSellingListBinding itemView){
            super(itemView.getRoot());

            this.bestSellingListBinding = itemView;
        }
    }
}
