package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class DeliveryMainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_main);

        listView = findViewById(R.id.order_lv);
    }

    public void goToOrderConfirm(View v){
        Intent intent = new Intent();
        intent.setClass(this, DeliveryOrderConfirm.class);
        startActivity(intent);
    }
}