package com.yan.day05exercisetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {
    private static final String KEY_PRODUCT_LIST = "product name";
    private static final String KEY_PRODUCT_TOTAL_PRICE = "product total price";

    private ImageButton mSummaryBack;
    private TextView mTextViewTotalPrice;
    private ArrayList<Product> mProductArrayList = new ArrayList<>();
    private ArrayList<Product> mProductFiltered = new ArrayList<>();


    private double mProductTotalPrice;
    private ListView mListViewSummary;
    private ProductAdapter mProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent intent = getIntent();

        /**Display ListView*/
        mProductArrayList = (ArrayList<Product>) intent.getSerializableExtra(KEY_PRODUCT_LIST);
        for (int i = 0; i < mProductArrayList.size(); i++) {
            if (mProductArrayList.get(i).getProductCount() != 0) {
                mProductFiltered.add(mProductArrayList.get(i));
                mProductTotalPrice+=mProductArrayList.get(i).getProductPrice()*mProductArrayList.get(i).getProductCount();
            }
        }
        mProductAdapter = new ProductAdapter(mProductFiltered);
        mListViewSummary = (ListView) findViewById(R.id.summary_list_view);
        mListViewSummary.setAdapter(mProductAdapter);

        /**Display Total Price*/
        mTextViewTotalPrice = (TextView) findViewById(R.id.summary_total_price_number);
        mTextViewTotalPrice.setText(String.valueOf(mProductTotalPrice));
        /**Press Back on Toolbar*/

        mSummaryBack = (ImageButton) findViewById(R.id.summary_back);
        mSummaryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SummaryActivity.this.onBackPressed();
            }
        });
    }
}

