package com.yan.day05exercisetest;

import java.io.Serializable;

public class Product implements Serializable {
    private String mProductName;
    private int mProductCount;
    private double mProductPrice;

    public Product(String productName, int productCount, double productPrice) {
        mProductName = productName;
        mProductCount = productCount;
        mProductPrice = productPrice;
    }


    public String getProductName() {
        return mProductName;
    }


    public int getProductCount() {
        return mProductCount;
    }

    public void setProductCount(int productCount) {
        mProductCount = productCount;
    }

    public double getProductPrice() {
        return mProductPrice;
    }

    public double getProductTotalPrice() {
        return mProductPrice*mProductCount;
    }
}
