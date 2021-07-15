package com.example.shopping_api.ProductDetails;

import android.content.Intent;

import com.example.shopping_api.Products.ProductsInterface;
import com.example.shopping_api.moduls.DetailedProduct;
import com.example.shopping_api.moduls.NewArrivals;
import com.example.shopping_api.network.ApiClient;
import com.example.shopping_api.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsPresenter implements DetailsInterface.DetailsPresenter {

    private ApiService apiService = ApiClient.getClient().create(ApiService.class);

    DetailsInterface.ProductDetailedView productDetailedView;

    public DetailsPresenter(DetailsInterface.ProductDetailedView productDetailedView) {
        this.productDetailedView = productDetailedView;
    }


    @Override
    public void details(String id) {
        Call<DetailedProduct> details = apiService.details("1" , id ,"en");

        details.enqueue(new Callback<DetailedProduct>() {
            @Override
            public void onResponse(Call<DetailedProduct> call, Response<DetailedProduct> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
                        productDetailedView.onSuccess(response.body());
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
}
