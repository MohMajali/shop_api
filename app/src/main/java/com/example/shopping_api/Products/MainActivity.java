package com.example.shopping_api.Products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.shopping_api.Adapters.BestBrandAdapter;
import com.example.shopping_api.Adapters.BestDealsAdapter;
import com.example.shopping_api.Adapters.BestSellingAdapter;
import com.example.shopping_api.Adapters.LargeCategoryAdapter;
import com.example.shopping_api.Adapters.SmallCategoryAdapter;
import com.example.shopping_api.Adapters.FirstSliderAdapter;
import com.example.shopping_api.Adapters.LargePromotionsAdapter;
import com.example.shopping_api.Adapters.NewArrivalsAdapter;
import com.example.shopping_api.Adapters.SecondSliderAdapter;
import com.example.shopping_api.Adapters.ThirdSliderAdapter;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.ActivityMainBinding;
import com.example.shopping_api.moduls.BestSelling;
import com.example.shopping_api.moduls.Category;
import com.example.shopping_api.moduls.Deals;
import com.example.shopping_api.moduls.Feed;
import com.example.shopping_api.moduls.FirstSlider;
import com.example.shopping_api.moduls.LargePromotion;
import com.example.shopping_api.moduls.NewArrivals;
import com.example.shopping_api.moduls.SecondSlider;
import com.example.shopping_api.moduls.ShopByBrand;
import com.example.shopping_api.moduls.ThirdSlider;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements ProductsInterface.ProductsView{

    ProductsPresenter anInterface;
    ActivityMainBinding activityMainBinding;

    ArrayList<LargePromotion> largePromotionList;
    ArrayList<Category> smallCategories;
    ArrayList<NewArrivals> newArrivals;
    ArrayList<FirstSlider> firstSliders;
    ArrayList<SecondSlider> secondSliders;
    ArrayList<Category> largeCategories;
    ArrayList<BestSelling> bestSellings;
    ArrayList<ShopByBrand> shopByBrands;
    ArrayList<Deals> deals;
    ArrayList<ThirdSlider> thirdSliders;

    RecyclerView.Adapter largePromotionAdapter;
    RecyclerView.Adapter smallCategoryAdapter;
    RecyclerView.Adapter newsArrivalsAdapter;
    RecyclerView.Adapter largeCategoryAdapter;
    RecyclerView.Adapter bestSellingAdapter;
    RecyclerView.Adapter shopByBrandAdapter;
    RecyclerView.Adapter bestDealsAdapter;
    FirstSliderAdapter firstSliderAdapter;
    SecondSliderAdapter secondSliderAdapter;
    ThirdSliderAdapter thirdSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        anInterface = new ProductsPresenter(this);



        anInterface.feed();


    }

    @Override
    public void onSuccess(Feed feed) {

        String newArrival = feed.getNew_arrival_title();
        String bestSelling = feed.getBest_selling_title();
        String brandShop = feed.getBrand_title();
        String dealsDay = feed.getDeals_title();






        largePromotionList = new ArrayList<>();
        smallCategories = new ArrayList<>();
        newArrivals = new ArrayList<>();
        firstSliders = new ArrayList<>();
        secondSliders = new ArrayList<>();
        largeCategories = new ArrayList<>();
        bestSellings = new ArrayList<>();
        shopByBrands = new ArrayList<>();
        deals = new ArrayList<>();
        thirdSliders = new ArrayList<>();

        largePromotionList.addAll(feed.getLargePromotion());
        smallCategories.addAll(feed.getCategory());
        newArrivals.addAll(feed.getNew_arrivals());
        firstSliders.addAll(feed.getFirst_slider());
        secondSliders.addAll(feed.getSecond_slider());
        largeCategories.addAll(feed.getCategory());
        bestSellings.addAll(feed.getBest_selling());
        shopByBrands.addAll(feed.getShop_by_brand());
        deals.addAll(feed.getDeals());
        thirdSliders.addAll(feed.getThird_slider());

        largePromotionAdapter = new LargePromotionsAdapter(getApplicationContext(), largePromotionList);
        smallCategoryAdapter = new SmallCategoryAdapter(getApplicationContext() , smallCategories);
        newsArrivalsAdapter = new NewArrivalsAdapter(getApplicationContext() , newArrivals);
        firstSliderAdapter = new FirstSliderAdapter(getApplicationContext() , firstSliders);
        secondSliderAdapter = new SecondSliderAdapter(getApplicationContext(), secondSliders);
        largeCategoryAdapter = new LargeCategoryAdapter(getApplicationContext() , largeCategories);
        bestSellingAdapter = new BestSellingAdapter(getApplicationContext() , bestSellings);
        shopByBrandAdapter = new BestBrandAdapter(getApplicationContext() , shopByBrands);
        bestDealsAdapter = new BestDealsAdapter(getApplicationContext() , deals);
        thirdSliderAdapter = new ThirdSliderAdapter(getApplicationContext() , thirdSliders);

        checkingForCounts(newArrival , bestSelling , brandShop , dealsDay);

        animationFirstSlider();
        animationSecondSlider();
        animationThirdSlider();
    }

    @Override
    public void onFailure() {
        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
    }

    public void animationFirstSlider(){
        //Animations of first Slider 1

        activityMainBinding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        activityMainBinding.imageSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        activityMainBinding.imageSlider.startAutoCycle();
    }

    public void animationSecondSlider(){
        //Animations of first Slider 2

        activityMainBinding.imageSlider2.setIndicatorAnimation(IndicatorAnimationType.WORM);
        activityMainBinding.imageSlider2.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        activityMainBinding.imageSlider2.startAutoCycle();
    }

    public void animationThirdSlider(){
        //Animations of first Slider 2

        activityMainBinding.imageSlider3.setIndicatorAnimation(IndicatorAnimationType.WORM);
        activityMainBinding.imageSlider3.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        activityMainBinding.imageSlider3.startAutoCycle();
    }

    public void checkingForCounts(String newArrival , String bestSelling , String brandShop , String dealsDay){
        if(largePromotionAdapter.getItemCount() == 0){
            activityMainBinding.promoRecycle.setVisibility(View.GONE);
        } else {
            activityMainBinding.promoRecycle.setAdapter(largePromotionAdapter);
        }

        if(smallCategoryAdapter.getItemCount() == 0){
            activityMainBinding.smallView.setVisibility(View.GONE);
        } else {
            activityMainBinding.smallView.setAdapter(smallCategoryAdapter);
        }

        if(newsArrivalsAdapter.getItemCount() == 0){
            activityMainBinding.arrivalsRecycle.setVisibility(View.GONE);
            activityMainBinding.newArrivals.setVisibility(View.GONE);
        } else {
            activityMainBinding.arrivalsRecycle.setAdapter(newsArrivalsAdapter);
            activityMainBinding.newArrivals.setText(newArrival);
        }

        if(firstSliderAdapter.getCount() == 0){
            activityMainBinding.imageSlider.setVisibility(View.GONE);
        } else {
            activityMainBinding.imageSlider.setSliderAdapter(firstSliderAdapter);
        }

        if(secondSliderAdapter.getCount() == 0){
            activityMainBinding.imageSlider2.setVisibility(View.GONE);
        } else {
            activityMainBinding.imageSlider2.setSliderAdapter(secondSliderAdapter);
        }

        if(largeCategoryAdapter.getItemCount() == 0){
            activityMainBinding.largeView.setVisibility(View.GONE);
        } else {
            activityMainBinding.largeView.setAdapter(largeCategoryAdapter);
        }

        if(bestSellingAdapter.getItemCount() == 0){
            activityMainBinding.bestSelling.setVisibility(View.GONE);
            activityMainBinding.bestSelling.setVisibility(View.GONE);
        } else {
            activityMainBinding.bestSelling.setAdapter(bestSellingAdapter);
            activityMainBinding.bestsellingTxt.setText(bestSelling);
        }

        if(shopByBrandAdapter.getItemCount() == 0){
            activityMainBinding.brandSelling.setVisibility(View.GONE);
            activityMainBinding.brand.setVisibility(View.GONE);
        } else {
            activityMainBinding.brandSelling.setAdapter(shopByBrandAdapter);
            activityMainBinding.brand.setText(brandShop);
        }

        if(bestDealsAdapter.getItemCount() == 0){
            activityMainBinding.dealsDay.setVisibility(View.GONE);
            activityMainBinding.dealsDay.setVisibility(View.GONE);
        } else {
            activityMainBinding.dealsDay.setAdapter(bestDealsAdapter);
            activityMainBinding.deals.setText(dealsDay);
        }

        if (thirdSliderAdapter.getCount() == 0){
            activityMainBinding.imageSlider3.setVisibility(View.GONE);
        } else {
            activityMainBinding.imageSlider3.setSliderAdapter(thirdSliderAdapter);
        }

    }
}