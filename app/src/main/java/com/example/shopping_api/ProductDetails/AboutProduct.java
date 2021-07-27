package com.example.shopping_api.ProductDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
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
import com.example.shopping_api.moduls.ProductInfo;
import com.example.shopping_api.moduls.SizeAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AboutProduct extends AppCompatActivity implements DetailsInterface.ProductDetailedView,OnClick {

    ActivityAboutProductBinding aboutProductBinding;
    DetailsPresenter detailsPresenter;

    //Vairation vairation;

    List<ProductInfo> productInfo;
    ImageProductAdapter imageProductAdapter;
    ShortDiscAdapter shortDiscAdapter;
    DetailsAdapter detailsAdapter;
    OptionsAdapter optionsAdapter;
    SizeAdapter sizeAdapter;

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
        optionsAdapter = new OptionsAdapter(getApplicationContext(),detailedProduct.getData().bigVariation() ,this);
        sizeAdapter = new SizeAdapter(getApplicationContext() , detailedProduct.getData().bigVariation().get(0).getVariations() ,this);

        aboutProductBinding.imageProdcute.setAdapter(imageProductAdapter);
        aboutProductBinding.shotDisc.setAdapter(shortDiscAdapter);
        aboutProductBinding.details.setAdapter(detailsAdapter);
        aboutProductBinding.colors.setAdapter(optionsAdapter);
        aboutProductBinding.options.setAdapter(sizeAdapter);


    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onError(Throwable t) {

    }

    private static final String TAG = "AboutProduct";
    @Override
    public void onClickListener(RecyclerView.Adapter adapter, int position) {
        if(adapter instanceof OptionsAdapter){
            //Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
            BigVariation bigVariation = optionsAdapter.getBigVariation(position);

            sizeAdapter.setNewSize(bigVariation.getVariations());
            Log.e(TAG, "onClickListener: " + bigVariation.getVariations().size());
            sizeAdapter.notifyDataSetChanged();


        } else if(adapter instanceof SizeAdapter){
            Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
            Log.i("Clicked", "HIIIIII");
        }

    }
}