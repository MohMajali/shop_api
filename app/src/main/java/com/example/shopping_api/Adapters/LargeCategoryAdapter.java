package com.example.shopping_api.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.LargeCategoryListBinding;
import com.example.shopping_api.moduls.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LargeCategoryAdapter extends RecyclerView.Adapter<LargeCategoryAdapter.ViewHolder> {

    Context context;
    List<Category> list;

//    LargeCategoryAdapter largeCategoryAdapter;
    LargeCategoryListBinding largeCategoryListBinding;
    public LargeCategoryAdapter(Context context , List<Category> categoryList){
        this.context = context;
        this.list = categoryList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        largeCategoryListBinding = LargeCategoryListBinding.inflate(layoutInflater , parent , false);
        return new ViewHolder(largeCategoryListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Category category = list.get(position);
        String img_url = category.getImage();
        String title = category.getTitle();
        final String IMAGE_URL = "https://backendapp.fikrajo.com" + img_url;

        if(img_url.isEmpty()){
            largeCategoryListBinding.largeCatImg.setImageResource(R.drawable.ic_arrow_right_alt);
        } else {
            Picasso.with(holder.largeCategoryListBinding.largeCatImg.getContext()).load(IMAGE_URL).error(R.drawable.ic_search).
                    into(holder.largeCategoryListBinding.largeCatImg);
        }

        largeCategoryListBinding.largenames.setText(title);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LargeCategoryListBinding largeCategoryListBinding;

        public ViewHolder(@NonNull LargeCategoryListBinding itemView) {
            super(itemView.getRoot());
            this.largeCategoryListBinding = itemView;
        }
    }
}
