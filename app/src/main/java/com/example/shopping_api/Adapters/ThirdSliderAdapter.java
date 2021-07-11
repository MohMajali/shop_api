package com.example.shopping_api.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.shopping_api.R;
import com.example.shopping_api.databinding.FirstSliderListBinding;
import com.example.shopping_api.databinding.ThirdSliderListBinding;
import com.example.shopping_api.moduls.ThirdSlider;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ThirdSliderAdapter extends SliderViewAdapter<SliderViewAdapter.ViewHolder> {

    Context context;
    List<ThirdSlider> list;

    ThirdSliderListBinding thirdSliderListBinding;

    public ThirdSliderAdapter(Context context , List<ThirdSlider> thirdSliders){
        this.context = context;
        this.list = thirdSliders;
    }

    @Override
    public SliderViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        thirdSliderListBinding = ThirdSliderListBinding.inflate(layoutInflater , parent , false);
        return new ViewHolder(thirdSliderListBinding);
    }

    @Override
    public void onBindViewHolder(SliderViewAdapter.ViewHolder viewHolder, int position) {

        ThirdSlider thirdSlider = list.get(position);

        String img_url = thirdSlider.getImage();
        String title = thirdSlider.getTitle();

        final String IMAGE_URL = "https://backendapp.fikrajo.com" + img_url;

        if(img_url.isEmpty()){
            thirdSliderListBinding.ivAutoImageSlider3.setImageResource(R.drawable.ic_arrow_right_alt);
        }else{
            Picasso.with(thirdSliderListBinding.ivAutoImageSlider3.getContext()).load(IMAGE_URL).error(R.drawable.ic_search).
                    into(thirdSliderListBinding.ivAutoImageSlider3);
        }

        thirdSliderListBinding.tvAutoImageSlider3.setText(title);
        thirdSliderListBinding.tvAutoImageSlider3.setTextSize(16);
        thirdSliderListBinding.tvAutoImageSlider3.setTextColor(Color.BLACK);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    static class ViewHolder extends SliderViewAdapter.ViewHolder{

        ThirdSliderListBinding sliderListBinding;
        public ViewHolder(ThirdSliderListBinding itemView){
            super(itemView.getRoot());
            this.sliderListBinding = itemView;
        }
    }
}
