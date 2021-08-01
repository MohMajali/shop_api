package com.example.shopping_api.Products;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
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
import com.example.shopping_api.databinding.NavHeaderBinding;
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

public class MainActivity extends AppCompatActivity implements ProductsInterface.ProductsView {

    ProductsPresenter anInterface;
    ActivityMainBinding activityMainBinding;
    NavHeaderBinding navHeaderBinding;

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

    ActionBarDrawerToggle mActionBar;

    int count = 10;
    TextView cartText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        anInterface = new ProductsPresenter(this);

        //Drawers..etc
        mActionBar = new ActionBarDrawerToggle(this, activityMainBinding.mainDrawerLayout, R.string.open, R.string.close);
        activityMainBinding.mainDrawerLayout.addDrawerListener(mActionBar);
        mActionBar.syncState();

        setSupportActionBar(activityMainBinding.myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_menu);


        //Default fragment to be displayed
        changeFragmentDisplay(R.id.home);

        anInterface.feed();
        setTitle("Home");

        findViewById(android.R.id.content).setFocusableInTouchMode(true);

    }

    private void changeFragmentDisplay(int item) {
        Fragment fragment = null;

        activityMainBinding.mainDrawerLayout.closeDrawer(Gravity.START);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu , menu);

        final MenuItem menuItem = menu.findItem(R.id.cart);
        menuItem.setVisible(true);
        View actionView = menuItem.getActionView();
        cartText = actionView.findViewById(R.id.cart_badge);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mActionBar.onOptionsItemSelected(item)) {
            return true;
        } else {
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUpBadge(int cartCount){
        String cart = cartText.getText().toString();

        if(cart.isEmpty()){
            if(count == 0){
                cartText.setText("0");
            } else {
                cartText.setText(String.valueOf(cartCount));;
            }
        }
    }

    @Override
    public void onSuccess(Feed feed) {

        String newArrival = feed.getNew_arrival_title();
        String bestSelling = feed.getBest_selling_title();
        String brandShop = feed.getBrand_title();
        String dealsDay = feed.getDeals_title();
        int cartCount = feed.getCart_count();

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
        smallCategoryAdapter = new SmallCategoryAdapter(getApplicationContext(), smallCategories);
        newsArrivalsAdapter = new NewArrivalsAdapter(getApplicationContext(), newArrivals);
        firstSliderAdapter = new FirstSliderAdapter(getApplicationContext(), firstSliders);
        secondSliderAdapter = new SecondSliderAdapter(getApplicationContext(), secondSliders);
        largeCategoryAdapter = new LargeCategoryAdapter(getApplicationContext(), largeCategories);
        bestSellingAdapter = new BestSellingAdapter(getApplicationContext(), bestSellings);
        shopByBrandAdapter = new BestBrandAdapter(getApplicationContext(), shopByBrands);
        bestDealsAdapter = new BestDealsAdapter(getApplicationContext(), deals);
        thirdSliderAdapter = new ThirdSliderAdapter(getApplicationContext(), thirdSliders);

        checkingForCounts(newArrival, bestSelling, brandShop, dealsDay);
        setUpBadge(cartCount);

        animationFirstSlider();
        animationSecondSlider();
        animationThirdSlider();
        coloringItems(feed);
        putInTexts();
    }

    @Override
    public void onFailure() {
        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(Throwable t) {
        Log.i("error", t.getLocalizedMessage());
    }

    public void animationFirstSlider() {
        //Animations of first Slider 1

        activityMainBinding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        activityMainBinding.imageSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        activityMainBinding.imageSlider.startAutoCycle();
    }

    public void animationSecondSlider() {
        //Animations of first Slider 2

        activityMainBinding.imageSlider2.setIndicatorAnimation(IndicatorAnimationType.WORM);
        activityMainBinding.imageSlider2.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        activityMainBinding.imageSlider2.startAutoCycle();
    }

    public void animationThirdSlider() {
        //Animations of first Slider 2

        activityMainBinding.imageSlider3.setIndicatorAnimation(IndicatorAnimationType.WORM);
        activityMainBinding.imageSlider3.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        activityMainBinding.imageSlider3.startAutoCycle();
    }

    public void checkingForCounts(String newArrival, String bestSelling, String brandShop, String dealsDay) {
        if (largePromotionAdapter.getItemCount() == 0) {
            activityMainBinding.promoRecycle.setVisibility(View.GONE);
        } else {
            activityMainBinding.promoRecycle.setAdapter(largePromotionAdapter);
        }

        if (smallCategoryAdapter.getItemCount() == 0) {
            activityMainBinding.smallView.setVisibility(View.GONE);
        } else {
            activityMainBinding.smallView.setAdapter(smallCategoryAdapter);
        }

        if (newsArrivalsAdapter.getItemCount() == 0) {
            activityMainBinding.arrivalsRecycle.setVisibility(View.GONE);
            activityMainBinding.newArrivals.setVisibility(View.GONE);
        } else {
            activityMainBinding.arrivalsRecycle.setAdapter(newsArrivalsAdapter);
            activityMainBinding.newArrivals.setText(newArrival);
        }

        if (firstSliderAdapter.getCount() == 0) {
            activityMainBinding.imageSlider.setVisibility(View.GONE);
        } else {
            activityMainBinding.imageSlider.setSliderAdapter(firstSliderAdapter);
        }

        if (secondSliderAdapter.getCount() == 0) {
            activityMainBinding.imageSlider2.setVisibility(View.GONE);
        } else {
            activityMainBinding.imageSlider2.setSliderAdapter(secondSliderAdapter);
        }

        if (largeCategoryAdapter.getItemCount() == 0) {
            activityMainBinding.largeView.setVisibility(View.GONE);
        } else {
            activityMainBinding.largeView.setAdapter(largeCategoryAdapter);
        }

        if (bestSellingAdapter.getItemCount() == 0) {
            activityMainBinding.bestSelling.setVisibility(View.GONE);
            activityMainBinding.bestSelling.setVisibility(View.GONE);
        } else {
            activityMainBinding.bestSelling.setAdapter(bestSellingAdapter);
            activityMainBinding.bestsellingTxt.setText(bestSelling);
        }

        if (shopByBrandAdapter.getItemCount() == 0) {
            activityMainBinding.brandSelling.setVisibility(View.GONE);
            activityMainBinding.brand.setVisibility(View.GONE);
        } else {
            activityMainBinding.brandSelling.setAdapter(shopByBrandAdapter);
            activityMainBinding.brand.setText(brandShop);
        }

        if (bestDealsAdapter.getItemCount() == 0) {
            activityMainBinding.dealsDay.setVisibility(View.GONE);
            activityMainBinding.dealsDay.setVisibility(View.GONE);
        } else {
            activityMainBinding.dealsDay.setAdapter(bestDealsAdapter);
            activityMainBinding.deals.setText(dealsDay);
        }

        if (thirdSliderAdapter.getCount() == 0) {
            activityMainBinding.imageSlider3.setVisibility(View.GONE);
        } else {
            activityMainBinding.imageSlider3.setSliderAdapter(thirdSliderAdapter);
        }

    }

    public void coloringItems(Feed feed) {
        boolean isColor = feed.isShow_color();
        String iconColor = feed.getColor();
        int iconColor1 = Color.parseColor(iconColor);

        int iconColor2 = Color.parseColor(iconColor);
        ColorDrawable cd = new ColorDrawable();
        cd.setColor(iconColor2);

        int textColor = Color.parseColor("#808080");

        if (isColor) {

            //Text color changed
            ColorStateList textList = new ColorStateList(
                    new int[][]{new int[]{android.R.attr.state_checked}
                    },
                    new int[]{
                            textColor
                    }
            );

            //Icon color changed
            ColorStateList iconList = new ColorStateList(
                    new int[][]{new int[]{android.R.attr.state_checked}
                    },
                    new int[]{
                            iconColor1
                    }
            );
            activityMainBinding.mainNavView.setItemIconTintList(iconList);
            activityMainBinding.mainNavView.setItemTextColor(textList);

            final Drawable home = getResources().getDrawable(R.drawable.ic_home_menu);
            home.setColorFilter(iconColor1 , PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(home);

            final Drawable home2 = getResources().getDrawable(R.drawable.ic_cart);
            home2.setColorFilter(iconColor1 , PorterDuff.Mode.SRC_ATOP);

            activityMainBinding.searchLayout.setDefaultHintTextColor(ColorStateList.valueOf(iconColor1));
            activityMainBinding.search.setTextColor(ColorStateList.valueOf(iconColor1));
//            activityMainBinding.toolbarIv.setColorFilter(iconColor1);


        }
    }

    public void putInTexts() {
            navHeaderBinding = DataBindingUtil.inflate(getLayoutInflater(),
                    R.layout.nav_header, activityMainBinding.mainNavView, false);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int[] sourceCoordinates = new int[2];
            v.getLocationOnScreen(sourceCoordinates);
            float x = ev.getRawX() + v.getLeft() - sourceCoordinates[0];
            float y = ev.getRawY() + v.getTop() - sourceCoordinates[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom()) {
                hideKeyboard(this);
            }

        }
        return super.dispatchTouchEvent(ev);
    }
    private void hideKeyboard(Activity activity){
        if (activity != null && activity.getWindow() != null) {
            activity.getWindow().getDecorView();
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
                findViewById(android.R.id.content).clearFocus();
            }
        }
    }

}