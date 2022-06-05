package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomMealActivity extends AppCompatActivity {

    ListView listView;
    public static final String ALBUM_NO = "album_no";
    private final static String DB_NAME = "UberEat";
    private final static String TABLE_NAME = "product";
    private SQLiteDatabase myDatabase;
    private Cursor cursor;
    private String storeName;
    private String delPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_shoplist);

        Intent intent = getIntent();
        storeName = intent.getStringExtra("STORE_NAME");
        delPrice = intent.getStringExtra("DEL_PRICE");

        listView = findViewById(R.id.listview);
        TextView tv_storename = findViewById(R.id.storeName);
        tv_storename.setText(storeName);
        myDatabase = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        String querySQL = "SELECT * FROM " + TABLE_NAME;
        cursor = myDatabase.rawQuery(querySQL, null);

        ArrayList<CustomShopItem> arrayList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                arrayList.add(new CustomShopItem(R.drawable.mexico,cursor.getString(1),"$" + cursor.getString(2),cursor.getString(3)));
            }while (cursor.moveToNext());
        }


//        arrayList.add(new CustomShopItem(R.drawable.food,"蛋餅","$30", "好吃蛋餅"));
//        arrayList.add(new CustomShopItem(R.drawable.food,"豬肉蛋堡","$50", "肥美豬肉蛋堡"));
//        arrayList.add(new CustomShopItem(R.drawable.mexico,"薯條","$40","酥炸薯條"));

        CustomShopItemAdapter productAdapter = new CustomShopItemAdapter(this,R.layout.customer_shoplist,arrayList);

        listView.setAdapter(productAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(CustomMealActivity.this, CustomItemDetailActivity.class);
                intent.putExtra("MEAL_NAME", arrayList.get(i).Name);
                intent.putExtra("MEAL_PRICE", arrayList.get(i).price);
                intent.putExtra("DEL_PRICE",delPrice);
                intent.putExtra("STORE_NAME",storeName);
                startActivity(intent);
            }
        });
    }
}