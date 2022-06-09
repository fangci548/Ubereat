package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DeliveryAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_account);
    }

    public void onBack(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void goToOrderConfirm(View v){
        Intent intent = new Intent();
        intent.setClass(this, DeliveryOrderConfirm.class);
        startActivity(intent);
    }

    public void goToAccount(View v){
        Intent intent = new Intent();
        intent.setClass(this, DeliveryAccountActivity.class);
        startActivity(intent);
    }

    public void goToHome(View v){
        Intent intent = new Intent();
        intent.setClass(this, DeliveryMainActivity.class);
        startActivity(intent);
    }
}