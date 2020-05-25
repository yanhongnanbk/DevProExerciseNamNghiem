package com.yan.day05exercisetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private static final String KEY_USERNAME = "username";
    private EditText mEditText01,mEditText02;
    private TextView mTextViewError;
    static String userName;
    private Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEditText01 = (EditText)findViewById(R.id.login_username);
        mEditText02 = (EditText)findViewById(R.id.login_password);
        mTextViewError = (TextView) findViewById(R.id.login_error);
        mButtonLogin = (Button)findViewById(R.id.login_button);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText01.getText().toString().equals("")
                        ||mEditText02.getText().toString().equals("")){
                    mTextViewError.setText(R.string.empty_password_username);
                }else{
                    if(!Helper.validPassword(mEditText02.getText().toString())){
                        mTextViewError.setText(R.string.error_password);
                    }else{
                        userName = mEditText01.getText().toString();
                        Intent intent = new Intent(LoginActivity.this,AddItemToCartActivity.class);
                        intent.putExtra(KEY_USERNAME,userName);
                        startActivity(intent);
                    }
                }
            }
        });


    }

    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
