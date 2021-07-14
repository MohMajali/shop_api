package com.example.shopping_api.ProductDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.shopping_api.Adapters.ImageProductAdapter;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.ActivityAboutProductBinding;
import com.example.shopping_api.moduls.DetailedProduct;
import com.example.shopping_api.moduls.Vairation;

import java.util.ArrayList;
import java.util.List;

public class AboutProduct extends AppCompatActivity implements DetailsInterface.ProductDetailedView {

    ActivityAboutProductBinding aboutProductBinding;
    DetailsPresenter detailsPresenter;

    Vairation vairation;
    ImageProductAdapter imageProductAdapter;
    List<Vairation> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aboutProductBinding = DataBindingUtil.setContentView(this, R.layout.activity_about_product);
        detailsPresenter = new DetailsPresenter(this);

        String id =getIntent().getStringExtra("arrival-id");
        detailsPresenter.details(id);

    }

    @Override
    public void onSuccess(DetailedProduct detailedProduct) {

        vairation = new Vairation();

        images = new ArrayList<>();

        //images.addAll();

        imageProductAdapter = new ImageProductAdapter(getApplicationContext() , images);



    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onError(Throwable t) {

    }
}