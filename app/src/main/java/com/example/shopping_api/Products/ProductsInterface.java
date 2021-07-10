package com.example.shopping_api.Products;

import com.example.shopping_api.moduls.Feed;

public interface ProductsInterface {

    interface ProductsView{

        void onSuccess(Feed feed);
        void onFailure();
    }

    interface ProductsPresenter{

        void feed();
    }
}
