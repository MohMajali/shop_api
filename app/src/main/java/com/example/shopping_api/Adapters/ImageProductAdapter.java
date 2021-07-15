package com.example.shopping_api.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.R;
import com.example.shopping_api.databinding.ImageProListBinding;
import com.example.shopping_api.moduls.Vairation;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImageProductAdapter extends RecyclerView.Adapter<ImageProductAdapter.ViewHolder> {

    Context context;
    List<String> list;
    List<Vairation> vairations;
    ImageProListBinding imageProListBinding;


    public ImageProductAdapter(Context context , List<String> vairations){
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
        Vairation vairation = vairations.get(position);
        List<String> imgArray = vairation.getImages();

        String img1 = imgArray.get(0);
        final String IMG_URL = "https://backendapp.fikrajo.com" +img1;

        if (img1.isEmpty()){
            imageProListBinding.imgPro.setImageResource(R.drawable.ic_home);
        } else {
            Picasso.with(holder.imageProListBinding.imgPro.getContext()).load(IMG_URL).error(R.drawable.ic_cart).into(
                    holder.imageProListBinding.imgPro);
        }

    }

    @Override
    public int getItemCount() {
        return vairations.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageProListBinding imageProListBinding;
        public ViewHolder(@NonNull ImageProListBinding itemView){
            super(itemView.getRoot());
            this.imageProListBinding = itemView;
        }
    }
}
