package com.example.shopping_api.ProductDetails;

import com.example.shopping_api.moduls.DetailedProduct;

public interface DetailsInterface {

    interface ProductDetailedView{
        void onSuccess(DetailedProduct detailedProduct);
        void onFailure();
        void onError(Throwable t);

    }

    interface DetailsPresenter{

        void details(String id);
    }
}
