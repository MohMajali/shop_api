package com.example.shopping_api.Products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.shopping_api.Adapters.CategoryAdapter;
import com.example.shopping_api.Adapters.FirstSliderAdapter;
import com.example.shopping_api.Adapters.LargePromotionsAdapter;
import com.example.shopping_api.Adapters.NewArrivalsAdapter;
import com.example.shopping_api.Adapters.SecondSliderAdapter;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.ActivityMainBinding;
import com.example.shopping_api.moduls.Category;
import com.example.shopping_api.moduls.Feed;
import com.example.shopping_api.moduls.FirstSlider;
import com.example.shopping_api.moduls.LargePromotion;
import com.example.shopping_api.moduls.NewArrivals;
import com.example.shopping_api.moduls.SecondSlider;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements ProductsInterface.ProductsView{

    ProductsPresenter anInterface;
    ActivityMainBinding activityMainBinding;

    ArrayList<LargePromotion> largePromotionList;
    ArrayList<Category> smallCategories;
    ArrayList<NewArrivals> newArrivals;
    ArrayList<FirstSlider> firstSliders;
    ArrayList<SecondSlider> secondSliders;
    //ArrayList<Category> largeCategories;

    RecyclerView.Adapter largePromotionAdapter;
    RecyclerView.Adapter categoryAdapter;
    RecyclerView.Adapter newsArrivalsAdapter;
    FirstSliderAdapter firstSliderAdapter;
    SecondSliderAdapter secondSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        anInterface = new ProductsPresenter(this);



        anInterface.feed();


    }

    @Override
    public void onSuccess(Feed feed) {

        largePromotionList = new ArrayList<>();
        smallCategories = new ArrayList<>();
        newArrivals = new ArrayList<>();
        firstSliders = new ArrayList<>();
        secondSliders = new ArrayList<>();
        //largeCategories = new ArrayList<>();

        largePromotionList.addAll(feed.getLargePromotion());
        smallCategories.addAll(feed.getCategory());
        newArrivals.addAll(feed.getNew_arrivals());
        firstSliders.addAll(feed.getFirst_slider());
        secondSliders.addAll(feed.getSecond_slider());
        //largeCategories.addAll(feed.getCategory());

        largePromotionAdapter = new LargePromotionsAdapter(getApplicationContext(), largePromotionList);
        categoryAdapter = new CategoryAdapter(getApplicationContext() , smallCategories);
        newsArrivalsAdapter = new NewArrivalsAdapter(getApplicationContext() , newArrivals);
        firstSliderAdapter = new FirstSliderAdapter(getApplicationContext() , firstSliders);
        secondSliderAdapter = new SecondSliderAdapter(getApplicationContext(), secondSliders);

        activityMainBinding.promoRecycle.setAdapter(largePromotionAdapter);
        activityMainBinding.smallView.setAdapter(categoryAdapter);
        activityMainBinding.arrivalsRecycle.setAdapter(newsArrivalsAdapter);
        activityMainBinding.imageSlider.setSliderAdapter(firstSliderAdapter);
        activityMainBinding.imageSlider2.setSliderAdapter(secondSliderAdapter);

        //Animations of first Slider 1

        activityMainBinding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        activityMainBinding.imageSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        activityMainBinding.imageSlider.startAutoCycle();

        //Animations of first Slider 2

        activityMainBinding.imageSlider2.setIndicatorAnimation(IndicatorAnimationType.WORM);
        activityMainBinding.imageSlider2.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        activityMainBinding.imageSlider2.startAutoCycle();





    }

    @Override
    public void onFailure() {
        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
    }
}