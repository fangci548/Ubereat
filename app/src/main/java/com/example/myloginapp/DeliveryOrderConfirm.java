package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DeliveryOrderConfirm extends AppCompatActivity {

    private String name;
    private String shopName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_order_confirm);
    }

    public void onBack(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }
}