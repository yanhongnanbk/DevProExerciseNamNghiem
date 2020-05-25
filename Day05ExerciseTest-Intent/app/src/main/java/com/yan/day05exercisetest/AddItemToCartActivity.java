package com.yan.day05exercisetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddItemToCartActivity extends AppCompatActivity {
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PRODUCT_LIST = "product name";
    private static final String SHOPPING_CART_COUNT = "shopping cart count";
    private static final String TOTAL_PRICE = "total price";

    private static final String PRODUCT_LIST = "product list";

//    private static final String PRODUCT_COUNT = "product count";
    
    private ImageView mImageViewShoppingCart;
    private TextView mTextView,mTextViewShoppingCart,mTextViewTotalPrice;
    private ListView mListViewAddNew;
    public  ArrayList<Product> mProductArrayList = new ArrayList<>();
    public  ArrayList<String> mAddItemToCartArrayList = new ArrayList<>();

    private int count = 0;
    private double total_price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (savedInstanceState != null) {
//
//        }

        setContentView(R.layout.activity_add_item_to_cart);
        /**Welcome username*/
        mTextView = (TextView)findViewById(R.id.add_item_welcome);
        final Intent intent = getIntent();
        String welcome_username ="Welcome " +  intent.getStringExtra(KEY_USERNAME);
        mTextView.setText(welcome_username);

        /**Tạo danh sách hàng hóa*/

        for (int i = 0; i < 10; i++) {
            String productString = "Product #"+i;
            mProductArrayList.add(new Product(productString,0,10*(1+i)));
            mAddItemToCartArrayList.add(mProductArrayList.get(i).getProductName());
        }

        /**Hiển thị lên Listview*/
        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<>(getBaseContext(),android.R.layout.simple_list_item_1,mAddItemToCartArrayList);
        mListViewAddNew = (ListView)findViewById(R.id.add_item_list_view);
        mListViewAddNew.setAdapter(mArrayAdapter);

        /**Click on item*/
        mListViewAddNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Shopping Cart Counter*/
                count++;
                /*Single Item Counter*/
                int singleItemCount = mProductArrayList.get(position).getProductCount();
                singleItemCount++;
                mProductArrayList.get(position).setProductCount(singleItemCount);


                /*Shopping Cart Counter*/
                String productCount = String.valueOf(count);
                mTextViewShoppingCart = (TextView)findViewById(R.id.add_item_toolbar_shopping_cart_count);
                mTextViewShoppingCart.setText(productCount);
                /*Total price bottom screen*/
                total_price+=mProductArrayList.get(position).getProductTotalPrice();
                String productTotalPrice = String.valueOf(total_price);
                mTextViewTotalPrice = (TextView) findViewById(R.id.add_item_total_price_number);
                mTextViewTotalPrice.setText(productTotalPrice);

            }
        });

        /**Click vào giỏ hàng*/
        mImageViewShoppingCart = (ImageView)findViewById(R.id.add_item_toolbar_shopping_cart);
        mImageViewShoppingCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(AddItemToCartActivity.this,SummaryActivity.class);
                intent1.putExtra(KEY_PRODUCT_LIST,mProductArrayList);
                startActivity(intent1);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(SHOPPING_CART_COUNT,count);
        savedInstanceState.putDouble(TOTAL_PRICE,total_price);
        savedInstanceState.putSerializable(PRODUCT_LIST,mProductArrayList);

    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt(SHOPPING_CART_COUNT);
        total_price= savedInstanceState.getDouble(TOTAL_PRICE);
        mProductArrayList = (ArrayList<Product>)savedInstanceState.getSerializable(PRODUCT_LIST);

        mTextViewShoppingCart = (TextView)findViewById(R.id.add_item_toolbar_shopping_cart_count);
        mTextViewTotalPrice = (TextView) findViewById(R.id.add_item_total_price_number);
        mTextViewShoppingCart.setText(String.valueOf(count));
        mTextViewTotalPrice.setText(String.valueOf(total_price));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AddItemToCartActivity.this,LoginActivity.class));
    }

}
