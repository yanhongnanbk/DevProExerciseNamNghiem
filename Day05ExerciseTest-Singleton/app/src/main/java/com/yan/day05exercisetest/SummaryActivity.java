package com.yan.day05exercisetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {
    private static final String KEY_USERNAME = "username";

//    private String mUsername;

    private ImageButton mSummaryBack;
    private TextView mTextViewTotalPrice;
//    private ArrayList<Product> mProductArrayList = new ArrayList<>();
    private ArrayList<Product> mProductFiltered = new ArrayList<>();

    private double mProductTotalPrice = 0;
    private int mProductCount = 0;
    private ListView mListViewSummary;
    private ProductAdapter mProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

//        Intent intent = getIntent();
//        mUsername = intent.getStringExtra(KEY_USERNAME);

        /**Display ListView*/
//        mProductArrayList = (ArrayList<Product>) intent.getSerializableExtra(KEY_PRODUCT_LIST);
        for (int i = 0; i < ProductLab.getInstance().getProductArrayList().size(); i++) {
            if (ProductLab.getInstance().getProductArrayList().get(i).getProductCount()!=0){
                mProductFiltered.add(ProductLab.getInstance().getProductArrayList().get(i));
                mProductTotalPrice  +=  ProductLab.getInstance().getProductArrayList().get(i).getProductPrice() *
                                        ProductLab.getInstance().getProductArrayList().get(i).getProductCount();
//                mProductCount       +=  ProductLab.getInstance().getProductArrayList().get(i).getProductCount();
            }
        }
        mProductAdapter = new ProductAdapter(mProductFiltered);
        mListViewSummary = (ListView)findViewById(R.id.summary_list_view);
        mListViewSummary.setAdapter(mProductAdapter);

        /**Display Total Price*/
        mTextViewTotalPrice = (TextView)findViewById(R.id.summary_total_price_number);
        mTextViewTotalPrice.setText(String.valueOf(mProductTotalPrice));
        /**Press Back on Toolbar*/

        mSummaryBack = (ImageButton)findViewById(R.id.summary_back);
        mSummaryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SummaryActivity.this.onBackPressed();
//                Intent intent1 = new Intent(SummaryActivity.this,AddItemToCartActivity.class);
//                intent1.putExtra(KEY_USERNAME,mUsername)
//                        .putExtra(KEY_COUNT,mProductCount)
////                        .putExtra(KEY_PRODUCT_LIST,mProductArrayList)
//                        .putExtra(KEY_PRODUCT_TOTAL_PRICE,mProductTotalPrice);
//                startActivity(intent1);
            }
        });
    }

//    @Override
//    public void onBackPressed() {
//        Intent intent1 = new Intent(SummaryActivity.this,AddItemToCartActivity.class);
//        intent1.putExtra(KEY_USERNAME,mUsername);
//        startActivity(intent1);
//    }
}
