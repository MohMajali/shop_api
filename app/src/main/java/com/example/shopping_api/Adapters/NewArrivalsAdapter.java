package com.example.shopping_api.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.R;

import com.example.shopping_api.databinding.NewArrivalListBinding;
import com.example.shopping_api.moduls.Feed;
import com.example.shopping_api.moduls.NewArrivals;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewArrivalsAdapter extends RecyclerView.Adapter<NewArrivalsAdapter.ViewHolder> {

    Context context;
    List<NewArrivals> list;

    NewArrivalListBinding newArrivalListBinding;

    public NewArrivalsAdapter(Context context , List<NewArrivals> arrivals){
        this.context = context;
        this.list = arrivals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        newArrivalListBinding = NewArrivalListBinding.inflate(layoutInflater , parent , false);
        return new ViewHolder(newArrivalListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        NewArrivals newArrivals = list.get(position);

        String img_url = newArrivals.getImage();
        String title = newArrivals.getTitle();
        String oldPrice = newArrivals.getOld_price();
        String price = newArrivals.getPrice();

        boolean isOld = newArrivals.isIs_old();
        final String IMAGE_URL = "https://backendapp.fikrajo.com" + img_url;

        if(img_url.isEmpty()){
            newArrivalListBinding.arrImg.setImageResource(R.drawable.ic_arrow_right_alt);
        } else {
            Picasso.with(holder.newArrivalListBinding.arrImg.getContext()).load(IMAGE_URL).error(R.drawable.ic_search).into(holder.newArrivalListBinding.arrImg);
        }

        newArrivalListBinding.title.setText(title);

        if(isOld){
            newArrivalListBinding.old.setText(oldPrice);
            newArrivalListBinding.old.setPaintFlags(newArrivalListBinding.old.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            newArrivalListBinding.old.setText("Error");
        }

        newArrivalListBinding.price.setText(price);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        NewArrivalListBinding newArrivalListBinding;

        public ViewHolder(@NonNull NewArrivalListBinding itemView) {
            super(itemView.getRoot());
            this.newArrivalListBinding = itemView;
        }
    }
}
