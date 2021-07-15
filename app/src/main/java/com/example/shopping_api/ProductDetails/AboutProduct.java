package com.example.shopping_api.ProductDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.shopping_api.Adapters.DetailsAdapter;
import com.example.shopping_api.Adapters.ImageProductAdapter;
import com.example.shopping_api.Adapters.OptionsAdapter;
import com.example.shopping_api.Adapters.ShortDiscAdapter;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.ActivityAboutProductBinding;
import com.example.shopping_api.moduls.DetailedProduct;
import com.example.shopping_api.moduls.ProductInfo;
import com.example.shopping_api.moduls.Vairation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AboutProduct extends AppCompatActivity implements DetailsInterface.ProductDetailedView {

    ActivityAboutProductBinding aboutProductBinding;
    DetailsPresenter detailsPresenter;

    //Vairation vairation;

    List<ProductInfo> productInfo;
    ImageProductAdapter imageProductAdapter;
    ShortDiscAdapter shortDiscAdapter;
    DetailsAdapter detailsAdapter;
    OptionsAdapter optionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aboutProductBinding = DataBindingUtil.setContentView(this, R.layout.activity_about_product);
        detailsPresenter = new DetailsPresenter(this);

        String id = getIntent().getStringExtra("arrival-id");
        String imgUrl = getIntent().getStringExtra("img");
        Picasso.with(getApplicationContext()).load(imgUrl).into(aboutProductBinding.bigImage);
        detailsPresenter.details(id);

    }

    @Override
    public void onSuccess(DetailedProduct detailedProduct) {

        imageProductAdapter = new ImageProductAdapter(getApplicationContext(), detailedProduct.getData().bigVariation().get(0)
                .getVariations().get(0));

        productInfo = new ArrayList<>();
        productInfo.add(detailedProduct.getData());

        shortDiscAdapter = new ShortDiscAdapter(getApplicationContext() , productInfo);
        detailsAdapter = new DetailsAdapter(getApplicationContext() , productInfo);
        optionsAdapter = new OptionsAdapter(getApplicationContext(),detailedProduct.getData().bigVariation());

        aboutProductBinding.imageProdcute.setAdapter(imageProductAdapter);
        aboutProductBinding.shotDisc.setAdapter(shortDiscAdapter);
        aboutProductBinding.details.setAdapter(detailsAdapter);
        aboutProductBinding.colors.setAdapter(optionsAdapter);


    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onError(Throwable t) {

    }
}