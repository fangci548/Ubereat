package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CustomShopCartActivity extends AppCompatActivity {

//    String[] itemName={"蛋餅","豬肉蛋堡","薯條"};
//    String[] itemPrice={"30.00","50.00","40.00"};

//    ListView listView;
//    public static final String ALBUM_NO = "album_no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_shop_cart);

//        listView = findViewById(R.id.shop_cart_lv);
//
//        CustomShopCartAdapter adapter = new CustomShopCartAdapter(CustomShopCartActivity.this,itemName,itemPrice);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent();
//                intent.setClass(CustomShopCartActivity.this, CustomMealActivity.class);
//                intent.putExtra(ALBUM_NO, i);
//                startActivity(intent);
//            }
//        });
    }
}