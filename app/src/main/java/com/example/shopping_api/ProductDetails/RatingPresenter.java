/*
package com.example.shopping_api.ProductDetails;

import android.util.Log;

import com.example.shopping_api.moduls.Rating;
import com.example.shopping_api.network.ApiClient;
import com.example.shopping_api.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RatingPresenter implements RatingInterface.RatingPresenter {

    private ApiService apiService = ApiClient.getClient().create(ApiService.class);

    RatingInterface.RatingUpdate ratingUpdate;

    public RatingPresenter(RatingInterface.RatingUpdate ratingUpdate){
        this.ratingUpdate = ratingUpdate;
    }


    @Override
    public void rating(String id, float rate) {
        Call<Rating> ratingCall = apiService.rating("1" , id , rate, "en");

        ratingCall.enqueue(new Callback<Rating>() {
            @Override
            public void onResponse(Call<Rating> call, Response<Rating> response) {
                if(response.isSuccessful()){
                    if(response.body() != null){
                        ratingUpdate.onSuccess(response.body());
                    } else {
                        ratingUpdate.onFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<Rating> call, Throwable t) {
                ratingUpdate.onFailure();
                ratingUpdate.onError(t);
            }
        });
    }
}
*/
