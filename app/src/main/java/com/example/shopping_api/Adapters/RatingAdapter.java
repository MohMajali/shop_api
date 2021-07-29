/*
package com.example.shopping_api.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_api.ProductDetails.OnClick;
import com.example.shopping_api.ProductDetails.RatingInterface;
import com.example.shopping_api.databinding.RatingListBinding;
import com.example.shopping_api.moduls.Rating;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.ViewHolder> {

    Context context;
    List<Rating> list;
    RatingListBinding binding;
    OnClick onClickItem;
    float rate;

    public RatingAdapter() {
    }

    public RatingAdapter(Context context, List<Rating> ratings, OnClick onClickItem) {
        this.context = context;
        this.list = ratings;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = RatingListBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Rating rating = list.get(position);
        String average = rating.getAvg();
        int avg1 = rating.getAvg1();
        int avg2 = rating.getAvg2();
        int avg3 = rating.getAvg3();
        int avg4 = rating.getAvg4();
        int avg5 = rating.getAvg5();

        String avg1St = String.valueOf(avg1);
        String avg2St = String.valueOf(avg2);
        String avg3St = String.valueOf(avg3);
        String avg4St = String.valueOf(avg4);
        String avg5St = String.valueOf(avg5);

        //set progress avg
        binding.avg.setText(average);
        binding.prog1.setProgress(avg1);
        binding.prog2.setProgress(avg2);
        binding.prog3.setProgress(avg3);
        binding.prog4.setProgress(avg4);
        binding.prog5.setProgress(avg5);

        //set percent
        binding.textView6.setText(avg1St + "%");
        binding.textView7.setText(avg2St + "%");
        binding.textView8.setText(avg3St + "%");
        binding.textView9.setText(avg4St + "%");
        binding.textView10.setText(avg5St + "%");

    }

    public void updateRating(List<Rating> ratings) {
        */
/*list.clear();
        list.addAll(ratings);
        this.notifyDataSetChanged();*//*

        this.list = ratings;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        RatingListBinding ratingListBinding;

        public ViewHolder(RatingListBinding ratingListBinding) {
            super(ratingListBinding.getRoot());
            this.ratingListBinding = ratingListBinding;

        }
    }
}
*/
