package com.example.shopping_api.ProductDetails;

import com.example.shopping_api.databinding.RatingListBinding;
import com.example.shopping_api.moduls.Rating;

public interface RatingInterface {

    interface RatingUpdate{
        void onSuccess(Rating rating);
        void onFailure();
        void onError(Throwable t);

    }

    interface RatingPresenter{

        void rating(String id , float rate);
    }
}
