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
        setContentView(R.layout.activity_meal_activity);

        listView = findViewById(R.id.listview);

        ArrayList<product> arrayList = new ArrayList<>();

        arrayList.add(new product(R.drawable.food,"蛋餅","$30"));
        arrayList.add(new product(R.drawable.pizzahut,"豬肉蛋堡","$50"));
        arrayList.add(new product(R.drawable.maxico,"薯條","$40"));

        productAdapter productAdapter = new productAdapter(this,R.layout.custom_shop,arrayList);

        listView.setAdapter(productAdapter);
    }
}