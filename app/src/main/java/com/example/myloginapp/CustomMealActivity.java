package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomMealActivity extends AppCompatActivity {

    ListView listView;
    public static final String ALBUM_NO = "album_no";

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(CustomMealActivity.this, CustomItemDetailActivity.class);
                intent.putExtra(ALBUM_NO, i);
                startActivity(intent);
            }
        });
    }
}