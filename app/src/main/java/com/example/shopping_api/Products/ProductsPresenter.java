package com.example.shopping_api.Products;

import android.util.Log;
import android.widget.Toast;

import com.example.shopping_api.moduls.Feed;
import com.example.shopping_api.network.ApiClient;
import com.example.shopping_api.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsPresenter implements ProductsInterface.ProductsPresenter {

    private final ApiService apiService = ApiClient.getClient().create(ApiService.class);

    ProductsInterface.ProductsView productsView;

    public ProductsPresenter(ProductsInterface.ProductsView productsView) {
        this.productsView = productsView;
    }

    @Override
    public void feed() {

        Call<Feed> feed = apiService.feed("0", "en");


        feed.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null)
                        if (response.body() != null){

                            productsView.onSuccess(response.body());
                        }
                        else {
                            productsView.onFailure();
                        }
                }

            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                productsView.onFailure();
                productsView.onError(t);
            }
        });

    }


}
