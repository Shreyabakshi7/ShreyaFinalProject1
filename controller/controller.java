package com.example.anurag_pc.shreyafinalproject.controller;

import android.app.Application;

import com.example.anurag_pc.shreyafinalproject.ModelCart;
import com.example.anurag_pc.shreyafinalproject.ModelProducts;

import java.util.ArrayList;

/**
 * Created by Anurag-PC on 7/16/2017.
 */

public class controller extends Application {

    private ArrayList<ModelProducts> myProducts = new ArrayList<ModelProducts>();
    private ModelCart myCart = new ModelCart();


    public ModelProducts getProducts(int pPosition) {

        return myProducts.get(pPosition);
    }

    public void setProducts(ModelProducts Products) {

        myProducts.add(Products);

    }

    public ModelCart getCart() {

        return myCart;

    }

    public int getProductsArraylistSize() {

        return myProducts.size();
    }

}
