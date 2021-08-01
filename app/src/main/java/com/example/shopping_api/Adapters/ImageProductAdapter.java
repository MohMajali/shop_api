package com.example.shopping_api.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.ProductDetails.OnClick;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.ImageProListBinding;
import com.example.shopping_api.moduls.Variation;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImageProductAdapter extends RecyclerView.Adapter<ImageProductAdapter.ViewHolder> {


    Variation list;
    ImageProListBinding imageProListBinding;
    OnClick onClick;


    /*public ImageProductAdapter(Context context , Variation vairations){
        this.context = context;
        this.list = vairations;
    }*/

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        imageProListBinding = imageProListBinding.inflate(layoutInflater , parent , false);
        return new ViewHolder(imageProListBinding , onClick);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        List<String> imgArray = list.getImages();
        holder.bind(imgArray,position);

    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.getImages().size();
        }
        return 0;
    }

    public void setImages(Variation variation){
        this.list = variation;
        notifyDataSetChanged();
    }

    public void onClick(OnClick onClick){
        this.onClick = onClick;
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageProListBinding imageProListBinding;
        OnClick onClick;
        public ViewHolder(@NonNull ImageProListBinding imageProListBinding , OnClick onClick){
            super(imageProListBinding.getRoot());

            this.imageProListBinding = imageProListBinding;
            this.onClick = onClick;
            itemView.setOnClickListener(this);
        }

        public void bind(List<String> variation, int position){

            List<String> img = variation;
            String img1 = img.get(position);
            final String IMG_URL = "https://backendapp.fikrajo.com" +img1;

            if(img1.isEmpty()){
                imageProListBinding.largImgPro.setImageResource(R.drawable.ic_home);
            } else {
                Picasso.with(imageProListBinding.largImgPro.getContext()).load(IMG_URL).error(R.drawable.ic_cart).
                        into(imageProListBinding.largImgPro);
            }
            /*String img1 = imgArray.get(position);

            String imgIntent = imgArray.get(0);

            final String IMG_URL = "https://backendapp.fikrajo.com" +img1;

            if (img1.isEmpty()){
                imageProListBinding.largImgPro.setImageResource(R.drawable.ic_home);
            } else {
                Picasso.with(holder.imageProListBinding.largImgPro.getContext()).load(IMG_URL).error(R.drawable.ic_cart).into(
                        holder.imageProListBinding.largImgPro);
            }*/
        }

        @Override
        public void onClick(View v) {
            if(onClick != null){
                if(getAdapterPosition() != -1){
                    onClick.onClickListener(new ImageProductAdapter() , getAdapterPosition());
                }
            }
        }
    }
}
