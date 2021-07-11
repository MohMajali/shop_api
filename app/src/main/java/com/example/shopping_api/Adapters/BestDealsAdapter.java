package com.example.shopping_api.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.R;
import com.example.shopping_api.databinding.BestDayListBinding;
import com.example.shopping_api.databinding.BestSellingListBinding;
import com.example.shopping_api.databinding.BestSellingListBindingImpl;
import com.example.shopping_api.databinding.LargPromsListBinding;
import com.example.shopping_api.moduls.Deals;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BestDealsAdapter extends RecyclerView.Adapter<BestDealsAdapter.ViewHolder> {

    Context context;
    List<Deals> list;

    BestDayListBinding bestDayListBinding;

    public BestDealsAdapter(Context context, List<Deals> deals) {
        this.context = context;
        this.list = deals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        bestDayListBinding = BestDayListBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(bestDayListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Deals deals = list.get(position);

        String img_url = deals.getImage();
        String title = deals.getTitle();
        boolean isOld = deals.isIs_old();
        String oldPrice = deals.getOld_price();
        String price = deals.getPrice();

        final String IMAGE_URL = "https://backendapp.fikrajo.com" + img_url;

        bestDayListBinding.largeBestTitle.setText(title);

        if (img_url.isEmpty()) {
            bestDayListBinding.bestImg.setImageResource(R.drawable.ic_arrow_right_alt);
        } else {
            Picasso.with(holder.bestDayListBinding.bestImg.getContext()).load(IMAGE_URL).error(R.drawable.ic_search).into(
                    holder.bestDayListBinding.bestImg
            );
        }

        if (isOld) {
            bestDayListBinding.bestOldPrice.setText(oldPrice);
            bestDayListBinding.bestOldPrice.setPaintFlags(bestDayListBinding.bestOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        bestDayListBinding.bestPrice.setText(price);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        BestDayListBinding bestDayListBinding;

        public ViewHolder(@NonNull BestDayListBinding itemView) {
            super(itemView.getRoot());
            this.bestDayListBinding = itemView;
        }
    }
}
