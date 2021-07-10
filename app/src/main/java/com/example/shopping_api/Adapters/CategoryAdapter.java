package com.example.shopping_api.Adapters;

import android.content.Context;
import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.R;
import com.example.shopping_api.databinding.CategoryListBinding;
import com.example.shopping_api.moduls.Category;
import com.squareup.picasso.Picasso;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    Context context;
    List<Category> list;
    CategoryListBinding categoryListBinding;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.list = categoryList;
    }

    /*public boolean isSmall() {
        Feed feed = new Feed();
        boolean isSmall = feed.isSmall_category();
        return isSmall;
    }

    public boolean isLarge() {
        Feed feed = new Feed();
        boolean isLarge = feed.isLarge_category();
        return isLarge;
    }*/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater v = LayoutInflater.from(parent.getContext());
        categoryListBinding = CategoryListBinding.inflate(v, parent, false);
        return new ViewHolder(categoryListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Category category = list.get(position);
       // Feed feed = new Feed();
       /* boolean isSmall = feed.isSmall_category();
        boolean isLarge = feed.isLarge_category();*/
        String img_url = category.getImage();
        String title = category.getTitle();
        final String IMAGE_URL = "https://backendapp.fikrajo.com" + img_url;

        if (img_url.isEmpty()) {
            categoryListBinding.catImg.setImageResource(R.drawable.ic_arrow_right_alt);
        } else {
            Picasso.with(holder.categoryListBinding.catImg.getContext()).load(IMAGE_URL).error(R.drawable.ic_search).into(holder.categoryListBinding.catImg);
        }

        categoryListBinding.names.setText(title);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CategoryListBinding categoryListBinding;

        public ViewHolder(@NonNull CategoryListBinding itemView) {
            super(itemView.getRoot());
            this.categoryListBinding = itemView;
        }
    }
}
