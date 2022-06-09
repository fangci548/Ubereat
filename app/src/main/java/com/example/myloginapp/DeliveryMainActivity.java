package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DeliveryMainActivity extends AppCompatActivity {

    ListView listView;
    public static final String ALBUM_NO = "album_no";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_main);

        listView = findViewById(R.id.order_lv);
        ArrayList<DeliveryOrderItem> deliveryOrderList = new ArrayList<DeliveryOrderItem>();

        deliveryOrderList.add(new DeliveryOrderItem("Q1032457","麥當勞","10.00","800m"));
        deliveryOrderList.add(new DeliveryOrderItem("Q1073852","KFC","25.00","1.8km"));
        deliveryOrderList.add(new DeliveryOrderItem("Q1032457","必勝客","20.00","1km"));

        DeliveryOrderAdapter adapter = new DeliveryOrderAdapter(this, R.layout.deliver_order_list, deliveryOrderList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                intent.setClass(DeliveryMainActivity.this, DeliveryOrderConfirm.class);
                intent.putExtra(ALBUM_NO, position);
                startActivity(intent);

            }
        });

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