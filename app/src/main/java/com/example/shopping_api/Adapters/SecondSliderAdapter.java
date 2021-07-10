package com.example.shopping_api.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.shopping_api.R;
import com.example.shopping_api.databinding.FirstSliderListBinding;
import com.example.shopping_api.databinding.SecondSliderListBinding;
import com.example.shopping_api.moduls.FirstSlider;
import com.example.shopping_api.moduls.SecondSlider;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SecondSliderAdapter extends SliderViewAdapter<SliderViewAdapter.ViewHolder>{


    Context context;
    List<SecondSlider> list;

    SecondSliderListBinding secondSliderListBinding;

    public SecondSliderAdapter(Context context , List<SecondSlider> firstSliders){
        this.context = context;
        this.list = firstSliders;
    }
    @Override
    public SliderViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        secondSliderListBinding = SecondSliderListBinding.inflate(layoutInflater, parent , false);
        return new ViewHolder(secondSliderListBinding);
    }

    @Override
    public void onBindViewHolder(SliderViewAdapter.ViewHolder viewHolder, int position) {

        SecondSlider secondSlider = list.get(position);

        String img_url = secondSlider.getImage();
        String title = secondSlider.getTitle();
        final String IMAGE_URL = "https://backendapp.fikrajo.com" + img_url;

        if(img_url.isEmpty()){
            secondSliderListBinding.ivAutoImageSlider2.setImageResource(R.drawable.ic_arrow_right_alt);
        } else {
            Picasso.with(secondSliderListBinding.ivAutoImageSlider2.getContext()).load(IMAGE_URL).into(secondSliderListBinding.ivAutoImageSlider2);

        }

        secondSliderListBinding.tvAutoImageSlider2.setText(title);
        secondSliderListBinding.tvAutoImageSlider2.setTextSize(16);
        secondSliderListBinding.tvAutoImageSlider2.setTextColor(Color.BLACK);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    static class ViewHolder extends SliderViewAdapter.ViewHolder{

        SecondSliderListBinding secondSliderListBinding;
        public ViewHolder(SecondSliderListBinding itemView){
            super(itemView.getRoot());
            this.secondSliderListBinding = itemView;
        }
    }
}
