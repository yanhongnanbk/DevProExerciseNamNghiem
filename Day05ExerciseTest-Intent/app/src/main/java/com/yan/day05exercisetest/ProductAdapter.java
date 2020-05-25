package com.yan.day05exercisetest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private ArrayList<Product> mProductArrayList;
    private TextView mTextView01,mTextView02,mTextView03,mTextView04;

    public ProductAdapter(ArrayList<Product> productArrayList) {
        mProductArrayList = productArrayList;
    }

    @Override
    public int getCount() {
        return mProductArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = mProductArrayList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.summary_list_item,parent,false);
        }


        String productAmount = String.valueOf(product.getProductCount());
        String productPrice = String.valueOf(product.getProductPrice());
        String productTotalPrice = String.valueOf(product.getProductCount()*product.getProductPrice());
        mTextView01 = (TextView)convertView.findViewById(R.id.summary_product_name);
        mTextView02 =(TextView) convertView.findViewById(R.id.summary_product_count);
        mTextView03 = (TextView)convertView.findViewById(R.id.summary_product_price);
        mTextView04 = (TextView)convertView.findViewById(R.id.summary_product_price_single_total);

        mTextView01.setText(product.getProductName());
        mTextView02.setText(productAmount);
        mTextView03.setText(productPrice);
        mTextView04.setText(productTotalPrice);
        return convertView;
    }
}
