package com.example.shopping_api.network;

import com.example.shopping_api.moduls.DetailedProduct;
import com.example.shopping_api.moduls.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/get_app_configuration/{user_id}")
    Call<Feed> feed(@Path("user_id") String userId,
                    @Query("lang") String lang);

    @POST("api/get-product-details/{user_id}"+"/{/product_id}")
    Call<DetailedProduct> details(@Path("user_id") String userID,
                                  @Path("product_id") String id,
                                  @Query("lang") String lang);


}
