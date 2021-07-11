package com.example.shopping_api.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.SmallCategoryListBinding;
import com.example.shopping_api.moduls.Category;
import com.squareup.picasso.Picasso;

import java.util.List;


public class SmallCategoryAdapter extends RecyclerView.Adapter<SmallCategoryAdapter.ViewHolder> {

    Context context;
    List<Category> list;
    SmallCategoryListBinding smallCategoryListBinding;

    public SmallCategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.list = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater v = LayoutInflater.from(parent.getContext());
        smallCategoryListBinding = SmallCategoryListBinding.inflate(v, parent, false);
        return new ViewHolder(smallCategoryListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Category category = list.get(position);
        String img_url = category.getImage();
        String title = category.getTitle();
        final String IMAGE_URL = "https://backendapp.fikrajo.com" + img_url;

        if (img_url.isEmpty()) {
            smallCategoryListBinding.catImg.setImageResource(R.drawable.ic_arrow_right_alt);
        } else {
            Picasso.with(holder.smallCategoryListBinding.catImg.getContext()).load(IMAGE_URL).error(R.drawable.ic_search).into(holder.smallCategoryListBinding.catImg);
        }

        smallCategoryListBinding.names.setText(title);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SmallCategoryListBinding smallCategoryListBinding;

        public ViewHolder(@NonNull SmallCategoryListBinding itemView) {
            super(itemView.getRoot());
            this.smallCategoryListBinding = itemView;
        }
    }
}
