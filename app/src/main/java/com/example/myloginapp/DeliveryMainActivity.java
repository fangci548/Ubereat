package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DeliveryMainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_main);

        listView = findViewById(R.id.order_lv);
        ArrayList<DeliveryOrderItem> deliveryOrderList = new ArrayList<DeliveryOrderItem>();

        deliveryOrderList.add(new DeliveryOrderItem("1","麥當勞","10.00","800"));
        deliveryOrderList.add(new DeliveryOrderItem("2","KFC","25.00","1.8km"));
        deliveryOrderList.add(new DeliveryOrderItem("3","必勝客","20.00","1km"));

        DeliveryOrderAdapter adapter = new DeliveryOrderAdapter(this, R.layout.deliver_order_list, deliveryOrderList);

        listView.setAdapter(adapter);

    }

    public void goToOrderConfirm(View v){
        Intent intent = new Intent();
        intent.setClass(this, DeliveryOrderConfirm.class);
        startActivity(intent);
    }
}