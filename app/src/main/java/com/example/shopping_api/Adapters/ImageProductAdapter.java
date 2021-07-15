package com.example.shopping_api.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.ProductDetails.AboutProduct;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.ImageProListBinding;
import com.example.shopping_api.moduls.Vairation;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImageProductAdapter extends RecyclerView.Adapter<ImageProductAdapter.ViewHolder> {

    Context context;
    Vairation list;
    ImageProListBinding imageProListBinding;


    public ImageProductAdapter(Context context , Vairation vairations){
        this.context = context;
        this.list = vairations;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        imageProListBinding = imageProListBinding.inflate(layoutInflater , parent , false);
        return new ViewHolder(imageProListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        List<String> imgArray = list.getImages();

        String img1 = imgArray.get(position);
        Log.i("size" , String.valueOf(imgArray.size()));
        Log.i("lenght" , imgArray.get(position));
        Log.i("img1" , img1);

        String imgIntent = imgArray.get(0);
        Log.i("firstImg" , imgIntent);

        /*holder.imageProListBinding.largImgPro.setOnClickListener(v -> {
            Intent intent = new Intent(holder.imageProListBinding.largImgPro.getContext() , AboutProduct.class);
            intent.putExtra("img" , imgIntent);
            holder.imageProListBinding.largImgPro.getContext().startActivity(intent);
        });*/



        final String IMG_URL = "https://backendapp.fikrajo.com" +img1;

            if (img1.isEmpty()){
                imageProListBinding.largImgPro.setImageResource(R.drawable.ic_home);
            } else {
                Picasso.with(holder.imageProListBinding.largImgPro.getContext()).load(IMG_URL).error(R.drawable.ic_cart).into(
                        holder.imageProListBinding.largImgPro);
            }


    }

    @Override
    public int getItemCount() {
        return list.getImages().size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageProListBinding imageProListBinding;
        public ViewHolder(@NonNull ImageProListBinding itemView){
            super(itemView.getRoot());
            this.imageProListBinding = itemView;
        }
    }
}
