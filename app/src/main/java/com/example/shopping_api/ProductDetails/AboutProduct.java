package com.example.shopping_api.ProductDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopping_api.Adapters.ImageProductAdapter;
import com.example.shopping_api.Adapters.OptionsAdapter;
import com.example.shopping_api.R;
import com.example.shopping_api.databinding.ActivityAboutProductBinding;
import com.example.shopping_api.moduls.BigVariation;
import com.example.shopping_api.moduls.DetailedProduct;
import com.example.shopping_api.moduls.FavoriteData;
import com.example.shopping_api.moduls.Feed;
import com.example.shopping_api.moduls.Other;
import com.example.shopping_api.moduls.ProductInfo;
import com.example.shopping_api.moduls.Rating;
import com.example.shopping_api.Adapters.SizeAdapter;
import com.example.shopping_api.moduls.Variation;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class AboutProduct extends AppCompatActivity implements DetailsInterface.ProductDetailedView,OnClick {

    ActivityAboutProductBinding aboutProductBinding;
    DetailsPresenter detailsPresenter;

    List<ProductInfo> productInfo;
    List<Rating> ratings;
    ImageProductAdapter imageProductAdapter;
    OptionsAdapter optionsAdapter;
    SizeAdapter sizeAdapter;

    String imgUrl;
    float rateValue;

    BigVariation bigVariation;
    Variation variation;
    Feed feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        aboutProductBinding = DataBindingUtil.setContentView(this, R.layout.activity_about_product);
        detailsPresenter = new DetailsPresenter(this);

        String id = getIntent().getStringExtra("arrival-id");
        imgUrl = getIntent().getStringExtra("img");
        Picasso.with(getApplicationContext()).load(imgUrl).into(aboutProductBinding.bigImage);
        detailsPresenter.details(id);

        setUpImagesAdapter();
        setUpOptionAdapter();
        setUpSizeAdapter();


        aboutProductBinding.rate.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> rateValue = ratingBar.getRating());

        aboutProductBinding.rateBtn.setOnClickListener(v -> {
            detailsPresenter.rating(id , rateValue);
        });

        aboutProductBinding.favorite.setOnClickListener(v -> {
            detailsPresenter.favorite(id);
        });

        feed = new Feed();


    }

    private  void setUpOptionAdapter(){
        optionsAdapter = new OptionsAdapter();
        aboutProductBinding.colors.setAdapter(optionsAdapter);
       optionsAdapter.setColorClickListener(this);
    }

    private void setUpSizeAdapter(){
        sizeAdapter = new SizeAdapter();
        aboutProductBinding.sizes.setAdapter(sizeAdapter);
        sizeAdapter.onclickItemListen(this);
    }

    private void setUpImagesAdapter(){
        imageProductAdapter = new ImageProductAdapter();
        aboutProductBinding.imageProdcute.setAdapter(imageProductAdapter);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onSuccess(DetailedProduct detailedProduct) {

        imageProductAdapter.setImages(detailedProduct.getData().bigVariation().get(0).getVariations().get(0));

        productInfo = new ArrayList<>();
        productInfo.add(detailedProduct.getData());

        aboutProductBinding.title.setText(detailedProduct.getData().getTitle());
        aboutProductBinding.shortDisc.setText(detailedProduct.getData().getShortDesc());

        String color = detailedProduct.getData().getBigVariation().get(0).getColor();
        int colorText = Color.parseColor(color);

        if(detailedProduct.getData().getBigVariation().get(0).getVariations().get(0).isIs_old()){
            aboutProductBinding.oldPrice.setText(detailedProduct.getData().getBigVariation().get(0).getVariations().get(0).
                    getOld_price());
            aboutProductBinding.oldPrice.setPaintFlags(aboutProductBinding.oldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            aboutProductBinding.oldPrice.setTextColor(colorText);
            aboutProductBinding.orginPrice.setText(detailedProduct.getData().getBigVariation().get(0).
                    getVariations().get(0).getPrice() + detailedProduct.getData().getBigVariation().get(0).
                    getVariations().get(0).getCurrenccy());
        } else {
            aboutProductBinding.orginPrice.setText(detailedProduct.getData().getBigVariation().get(0).
                    getVariations().get(0).getPrice() + detailedProduct.getData().getBigVariation().get(0).getVariations().
                    get(0).getCurrenccy());
        }

        aboutProductBinding.detailsTxt.setText(detailedProduct.getData().getDetails());

        ratings = new ArrayList<>();
        ratings.add(detailedProduct.getOther().getRating());

        aboutProductBinding.imageProdcute.setAdapter(imageProductAdapter);
        optionsAdapter.setBigVariation(detailedProduct.getData().getBigVariation());
        sizeAdapter.setNewSize(detailedProduct.getData().bigVariation().get(0).getVariations());

        getFirstRating(detailedProduct.getOther().getRating());
        getFavorite(detailedProduct.getOther());
        showSheet(detailedProduct);
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onError(Throwable t) {
        Log.i("thorw" , t.toString());
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

    public void getFavorite(Other other){
        if(other.isIs_favorite()){
            aboutProductBinding.favorite.setText("Favorited");
        } else {
            aboutProductBinding.favorite.setText("Not Favorite");
        }
    }

    public void showSheet(DetailedProduct detailedProduct){
        aboutProductBinding.showSheet.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(AboutProduct.this);
            bottomSheetDialog.setContentView(R.layout.bottom_sheet);
            bottomSheetDialog.setCanceledOnTouchOutside(true);

            //init img, textViews
            final ImageView imageView = bottomSheetDialog.findViewById(R.id.productImg);
            final TextView textView = bottomSheetDialog.findViewById(R.id.productTitle);
            final TextView textView1 = bottomSheetDialog.findViewById(R.id.description);
            final Button button = bottomSheetDialog.findViewById(R.id.callBack);

            Picasso.with(getApplicationContext()).load(imgUrl).into(imageView);
            textView.setText(detailedProduct.getData().getTitle());
            textView1.setText(detailedProduct.getData().getDetails());
            button.setOnClickListener(v1 -> {
                Toast.makeText(AboutProduct.this,"Hello",Toast.LENGTH_LONG).show();
                bottomSheetDialog.dismiss();
            });
            bottomSheetDialog.show();
        });
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
            bigVariation = optionsAdapter.getBigVariation(position);
            sizeAdapter.setNewSize(bigVariation.getVariations());
            imageProductAdapter.setImages(bigVariation.getVariations().get(0));
            aboutProductBinding.orginPrice.setText(bigVariation.getVariations().get(0).getPrice() + bigVariation.getVariations().
                    get(0).getCurrenccy());

            sizeAdapter.selectedPosition = 0;
            sizeAdapter.notifyDataSetChanged();

        }
        if(adapter instanceof SizeAdapter){

            variation = sizeAdapter.getVariation(position);

            sizeAdapter.selectedPosition = position;
            sizeAdapter.notifyDataSetChanged();
        }

    }
}