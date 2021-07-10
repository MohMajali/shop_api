package com.example.shopping_api.network;

import com.example.shopping_api.moduls.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/get_app_configuration/" + "user_id")
    Call<Feed> feed(@Query("user_id") String userId,
                    @Query("lang") String lang);


}
