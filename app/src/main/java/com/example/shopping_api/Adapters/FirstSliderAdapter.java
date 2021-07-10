package com.example.shopping_api.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.FirstSliderListBinding;
import com.example.shopping_api.moduls.FirstSlider;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FirstSliderAdapter extends SliderViewAdapter<SliderViewAdapter.ViewHolder> {

    Context context;
    List<FirstSlider> list;

    FirstSliderListBinding sliderListBinding;

    public FirstSliderAdapter(Context context , List<FirstSlider> firstSliders){
        this.context = context;
        this.list = firstSliders;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        sliderListBinding = FirstSliderListBinding.inflate(layoutInflater, parent , false);
        return new ViewHolder(sliderListBinding);
    }

    @Override
    public void onBindViewHolder(SliderViewAdapter.ViewHolder viewHolder, int position) {

        FirstSlider firstSlider = list.get(position);

        String img_url = firstSlider.getImage();
        String title = firstSlider.getTitle();
        final String IMAGE_URL = "https://backendapp.fikrajo.com" + img_url;

        if(img_url.isEmpty()){
            sliderListBinding.ivAutoImageSlider.setImageResource(R.drawable.ic_arrow_right_alt);
        } else {
            Picasso.with(sliderListBinding.ivAutoImageSlider.getContext()).load(IMAGE_URL).into(sliderListBinding.ivAutoImageSlider);

        }

        sliderListBinding.tvAutoImageSlider.setText(title);
        sliderListBinding.tvAutoImageSlider.setTextSize(16);
        sliderListBinding.tvAutoImageSlider.setTextColor(Color.BLACK);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    static class ViewHolder extends SliderViewAdapter.ViewHolder{

        FirstSliderListBinding sliderListBinding;
        public ViewHolder(FirstSliderListBinding itemView){
            super(itemView.getRoot());
            this.sliderListBinding = itemView;
        }
    }
}
