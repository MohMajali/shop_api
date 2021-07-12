package com.example.shopping_api.Products;

import com.example.shopping_api.moduls.Feed;

public interface ProductsInterface {

    interface ProductsView{

        void onSuccess(Feed feed);
        void onFailure();
        void onError(Throwable t);
    }

    interface ProductsPresenter{

        void feed();
    }
}
