package com.example.shopping_api.ProductDetails;

import android.content.Intent;
import android.util.Log;

import com.example.shopping_api.Products.ProductsInterface;
import com.example.shopping_api.moduls.BaseFavorite;
import com.example.shopping_api.moduls.BaseRating;
import com.example.shopping_api.moduls.DetailedProduct;
import com.example.shopping_api.moduls.FavoriteData;
import com.example.shopping_api.moduls.NewArrivals;
import com.example.shopping_api.moduls.Other;
import com.example.shopping_api.moduls.Rating;
import com.example.shopping_api.network.ApiClient;
import com.example.shopping_api.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsPresenter implements DetailsInterface.DetailsPresenter{

    private ApiService apiService = ApiClient.getClient().create(ApiService.class);

    DetailsInterface.ProductDetailedView productDetailedView;

    public DetailsPresenter(DetailsInterface.ProductDetailedView productDetailedView) {
        this.productDetailedView = productDetailedView;
    }


    @Override
    public void details(String id) {
        Call<DetailedProduct> details = apiService.details("1", id, "en");

        details.enqueue(new Callback<DetailedProduct>() {
            @Override
            public void onResponse(Call<DetailedProduct> call, Response<DetailedProduct> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        productDetailedView.onSuccess(response.body());
                        productDetailedView.sizeSuccess(response.body().getData().bigVariation().get(0).getVariations().get(0));
                    } else {
                        productDetailedView.onFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<DetailedProduct> call, Throwable t) {
                productDetailedView.onFailure();
                productDetailedView.onError(t);

            }
        });
    }

    @Override
    public void rating(String id, float rate) {
        Call<BaseRating> ratingCall = apiService.rating("1", id, rate, "en");

        ratingCall.enqueue(new Callback<BaseRating>() {
            @Override
            public void onResponse(Call<BaseRating> call, Response<BaseRating> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        productDetailedView.ratingSuccess(response.body().getOtherRating().getRating());
                        Log.e("updated", String.valueOf(response.body().getOtherRating().getRating()));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseRating> call, Throwable t) {
                productDetailedView.onFailure();
                productDetailedView.onError(t);
            }
        });
    }

    @Override
    public void favorite(String proID) {
        Call<BaseFavorite> favoriteDataCall = apiService.favorite("1", proID, "en");
        favoriteDataCall.enqueue(new Callback<BaseFavorite>() {
            @Override
            public void onResponse(Call<BaseFavorite> call, Response<BaseFavorite> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        productDetailedView.favoriteSuccess(response.body().getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseFavorite> call, Throwable t) {
                productDetailedView.onFailure();
                productDetailedView.onError(t);
            }
        });
    }
}
