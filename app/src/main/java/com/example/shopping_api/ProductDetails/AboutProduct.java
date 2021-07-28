package com.example.shopping_api.ProductDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.example.shopping_api.Adapters.DetailsAdapter;
import com.example.shopping_api.Adapters.ImageProductAdapter;
import com.example.shopping_api.Adapters.OptionsAdapter;
import com.example.shopping_api.Adapters.RatingAdapter;
import com.example.shopping_api.Adapters.ShortDiscAdapter;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.ActivityAboutProductBinding;
import com.example.shopping_api.moduls.BigVariation;
import com.example.shopping_api.moduls.DetailedProduct;
import com.example.shopping_api.moduls.ProductInfo;
import com.example.shopping_api.moduls.Rating;
import com.example.shopping_api.Adapters.SizeAdapter;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class AboutProduct extends AppCompatActivity implements DetailsInterface.ProductDetailedView,OnClick,RatingInterface.RatingUpdate {

    ActivityAboutProductBinding aboutProductBinding;
    DetailsPresenter detailsPresenter;
    RatingPresenter ratingPresenter;

    //Vairation vairation;

    List<ProductInfo> productInfo;
    List<Rating> ratings;
    ImageProductAdapter imageProductAdapter;
    ShortDiscAdapter shortDiscAdapter;
    DetailsAdapter detailsAdapter;
    OptionsAdapter optionsAdapter;
    SizeAdapter sizeAdapter;
    RatingAdapter ratingAdapter;
    float rateValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aboutProductBinding = DataBindingUtil.setContentView(this, R.layout.activity_about_product);
        detailsPresenter = new DetailsPresenter(this);
        ratingPresenter = new RatingPresenter(this);

        String id = getIntent().getStringExtra("arrival-id");
        String imgUrl = getIntent().getStringExtra("img");
        Picasso.with(getApplicationContext()).load(imgUrl).into(aboutProductBinding.bigImage);
        detailsPresenter.details(id);

        aboutProductBinding.rate.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> rateValue = ratingBar.getRating());

        aboutProductBinding.rateBtn.setOnClickListener(v -> {
           ratingPresenter.rating(id , rateValue);
            ((Activity) this).finish();
            startActivity(((Activity) this).getIntent());
            ratingPresenter.rating(id , rateValue);
        });


    }

    @Override
    public void onSuccess(DetailedProduct detailedProduct) {

        imageProductAdapter = new ImageProductAdapter(getApplicationContext(), detailedProduct.getData().bigVariation().get(0)
                .getVariations().get(0));

        productInfo = new ArrayList<>();
        productInfo.add(detailedProduct.getData());

        ratings = new ArrayList<>();
        ratings.add(detailedProduct.getOther().getRating());

        shortDiscAdapter = new ShortDiscAdapter(getApplicationContext() , productInfo);
        detailsAdapter = new DetailsAdapter(getApplicationContext() , productInfo);
        optionsAdapter = new OptionsAdapter(getApplicationContext(),detailedProduct.getData().bigVariation() ,this);
        sizeAdapter = new SizeAdapter(getApplicationContext() , detailedProduct.getData().bigVariation().get(0).getVariations() ,this);
        ratingAdapter = new RatingAdapter(getApplicationContext() , ratings, this);

        aboutProductBinding.imageProdcute.setAdapter(imageProductAdapter);
        aboutProductBinding.shotDisc.setAdapter(shortDiscAdapter);
        aboutProductBinding.details.setAdapter(detailsAdapter);
        aboutProductBinding.colors.setAdapter(optionsAdapter);
        aboutProductBinding.options.setAdapter(sizeAdapter);
        aboutProductBinding.ratings.setAdapter(ratingAdapter);
    }

    @Override
    public void onSuccess(Rating rating) {
        //ratings = new ArrayList<>();
        //ratingAdapter.updateRating(ratings);
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onError(Throwable t) {

    }


    @Override
    public void onClickListener(RecyclerView.Adapter adapter, int position) {
        if(adapter instanceof OptionsAdapter){
            //Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
            BigVariation bigVariation = optionsAdapter.getBigVariation(position);

            sizeAdapter.setNewSize(bigVariation.getVariations());
            sizeAdapter.notifyDataSetChanged();


        } else if(adapter instanceof SizeAdapter){
            Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
            Log.i("Clicked", "HIIIIII");
        } else if(adapter instanceof RatingAdapter){}

    }
}