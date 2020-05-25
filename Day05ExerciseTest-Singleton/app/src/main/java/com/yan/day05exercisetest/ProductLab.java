package com.yan.day05exercisetest;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductLab {
    private static ProductLab sProductLab;
    private ArrayList<Product> mProductArrayList = null;

    public static ProductLab getInstance(){
        if (sProductLab==null){
            sProductLab = new ProductLab();
        }
        return sProductLab;
    }

    private ProductLab(){
        mProductArrayList = new ArrayList<>();
    }

    public ArrayList<Product> getProductArrayList(){
        return  this.mProductArrayList;
    }

    public void addToProductList(Product product){
        mProductArrayList.add(product);
    }
}


