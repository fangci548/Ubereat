package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomMealActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_shoplist);

        listView = findViewById(R.id.listview);

        ArrayList<CustomShopItem> arrayList = new ArrayList<>();

        arrayList.add(new CustomShopItem(R.drawable.food,"蛋餅","$30"));
        arrayList.add(new CustomShopItem(R.drawable.food,"豬肉蛋堡","$50"));
        arrayList.add(new CustomShopItem(R.drawable.maxico,"薯條","$40"));

        CustomShopItemAdapter productAdapter = new CustomShopItemAdapter(this,R.layout.customer_shop,arrayList);

        listView.setAdapter(productAdapter);
    }
}