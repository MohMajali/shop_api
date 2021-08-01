package com.example.shopping_api.ProductDetails;

import com.example.shopping_api.moduls.DetailedProduct;
import com.example.shopping_api.moduls.FavoriteData;
import com.example.shopping_api.moduls.Other;
import com.example.shopping_api.moduls.ProductInfo;
import com.example.shopping_api.moduls.Rating;
import com.example.shopping_api.moduls.Variation;

public interface DetailsInterface {

    interface ProductDetailedView{
        void onSuccess(DetailedProduct detailedProduct);
        void onFailure();
        void onError(Throwable t);
        void ratingSuccess(Rating rating);
        void favoriteSuccess(FavoriteData favoriteData);

    }

    interface DetailsPresenter{
        void details(String id);
        void rating(String id , float rate);
        void favorite(String proID);
    }
}
