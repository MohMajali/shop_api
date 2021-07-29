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
import com.example.shopping_api.Adapters.ShortDiscAdapter;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.ActivityAboutProductBinding;
import com.example.shopping_api.moduls.BigVariation;
import com.example.shopping_api.moduls.DetailedProduct;
import com.example.shopping_api.moduls.FavoriteData;
import com.example.shopping_api.moduls.Other;
import com.example.shopping_api.moduls.ProductInfo;
import com.example.shopping_api.moduls.Rating;
import com.example.shopping_api.Adapters.SizeAdapter;
import com.example.shopping_api.moduls.Variation;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class AboutProduct extends AppCompatActivity implements DetailsInterface.ProductDetailedView,OnClick {

    ActivityAboutProductBinding aboutProductBinding;
    DetailsPresenter detailsPresenter;
    //RatingPresenter ratingPresenter;

    //Vairation vairation;

    List<ProductInfo> productInfo;
    List<Rating> ratings;
    ImageProductAdapter imageProductAdapter;
    ShortDiscAdapter shortDiscAdapter;
    DetailsAdapter detailsAdapter;
    OptionsAdapter optionsAdapter;
    SizeAdapter sizeAdapter;
   // RatingAdapter ratingAdapter;
    float rateValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aboutProductBinding = DataBindingUtil.setContentView(this, R.layout.activity_about_product);
        detailsPresenter = new DetailsPresenter(this);
        //ratingPresenter = new RatingPresenter(this);

        String id = getIntent().getStringExtra("arrival-id");
        String imgUrl = getIntent().getStringExtra("img");
        Picasso.with(getApplicationContext()).load(imgUrl).into(aboutProductBinding.bigImage);
        detailsPresenter.details(id);
        setUpOptionAdapter();

        aboutProductBinding.rate.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> rateValue = ratingBar.getRating());

        aboutProductBinding.rateBtn.setOnClickListener(v -> {
            detailsPresenter.rating(id , rateValue);
        });

        aboutProductBinding.favorite.setOnClickListener(v -> {
            detailsPresenter.favorite(id);
        });


    }

    private  void setUpOptionAdapter(){

        optionsAdapter = new OptionsAdapter();
        aboutProductBinding.colors.setAdapter(optionsAdapter);
    }
    @Override
    public void onSuccess(DetailedProduct detailedProduct) {




        optionsAdapter.setBigVariation(detailedProduct.getData().getBigVariation());

        imageProductAdapter = new ImageProductAdapter(getApplicationContext(), detailedProduct.getData().bigVariation().get(0)
                .getVariations().get(0));

        productInfo = new ArrayList<>();
        productInfo.add(detailedProduct.getData());

        ratings = new ArrayList<>();
        ratings.add(detailedProduct.getOther().getRating());

        shortDiscAdapter = new ShortDiscAdapter(getApplicationContext() , productInfo);
        detailsAdapter = new DetailsAdapter(getApplicationContext() , productInfo);

        sizeAdapter = new SizeAdapter(getApplicationContext() , detailedProduct.getData().bigVariation().get(0).getVariations() ,this);
        //ratingAdapter = new RatingAdapter(getApplicationContext() , ratings, this);

        aboutProductBinding.imageProdcute.setAdapter(imageProductAdapter);
        aboutProductBinding.shotDisc.setAdapter(shortDiscAdapter);
        aboutProductBinding.details.setAdapter(detailsAdapter);
        aboutProductBinding.colors.setAdapter(optionsAdapter);

        //aboutProductBinding.ratings.setAdapter(ratingAdapter);

        getFirstRating(detailedProduct.getOther().getRating());


    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onError(Throwable t) {
        Log.i("thorw" , t.toString());
    }

    @Override
    public void sizeSuccess(Variation variation) {

        aboutProductBinding.options.setAdapter(sizeAdapter);
    }

    @Override
    public void ratingSuccess(Rating rating) {
        getUpdatedRating(rating);
    }

    @Override
    public void favoriteSuccess(FavoriteData favoriteData) {

        boolean favor = favoriteData.isIs_favorite();
        Log.i("fav", String.valueOf(favor));
        if(favor){
            aboutProductBinding.favorite.setText("Favotited");
        } else {
            aboutProductBinding.favorite.setText("Not Favorited");
        }
    }

    public void getFirstRating(Rating rating){
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
        aboutProductBinding.avg.setText(average);
        aboutProductBinding.prog1.setProgress(avg1);
        aboutProductBinding.prog2.setProgress(avg2);
        aboutProductBinding.prog3.setProgress(avg3);
        aboutProductBinding.prog4.setProgress(avg4);
        aboutProductBinding.prog5.setProgress(avg5);

        //set percent
        aboutProductBinding.textView6.setText(avg1St + "%");
        aboutProductBinding.textView7.setText(avg2St + "%");
        aboutProductBinding.textView8.setText(avg3St + "%");
        aboutProductBinding.textView9.setText(avg4St + "%");
        aboutProductBinding.textView10.setText(avg5St + "%");
    }

    public void getUpdatedRating(Rating rating){
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
        aboutProductBinding.avg.setText(average);
        aboutProductBinding.prog1.setProgress(avg1);
        aboutProductBinding.prog2.setProgress(avg2);
        aboutProductBinding.prog3.setProgress(avg3);
        aboutProductBinding.prog4.setProgress(avg4);
        aboutProductBinding.prog5.setProgress(avg5);

        //set percent
        aboutProductBinding.textView6.setText(avg1St + "%");
        aboutProductBinding.textView7.setText(avg2St + "%");
        aboutProductBinding.textView8.setText(avg3St + "%");
        aboutProductBinding.textView9.setText(avg4St + "%");
        aboutProductBinding.textView10.setText(avg5St + "%");
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
        }

    }
}