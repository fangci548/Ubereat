package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class CustomMainActivity extends AppCompatActivity {

    public static boolean VALID_USER = false;
    public static final String ALBUM_NO = "album_no";

    GridView gridview;

    String[] shopName = {"麥味登早餐","大苑子","麥當勞","必勝客","肯德基","可不可成熟紅茶","繼光香香雞"};
    int [] numberImage = {R.drawable.mwd,R.drawable.dayung,R.drawable.mcdonald,R.drawable.pizzahut,R.drawable.kfc,R.drawable.kebuketea,R.drawable.jgchicken};
    String[] fee = {"$20","$15","$35","$15","$10","$20","$15"};
    String[] time = {"20-30","5-10","20-30","10-15","5-10","25-30","15-25"};
    String[] star = {"4.5","4.8","4.6","4.5","4.6","4.9","4.8"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_main);

        if (!VALID_USER) {
            Intent intent = new Intent();
            intent.setClass(this, RoleChose.class);
            startActivity(intent);
        } else {
            gridview = findViewById(R.id.gridview);

            CustomMainAdapter adapter = new CustomMainAdapter(CustomMainActivity.this,shopName,numberImage,fee,time,star);
            gridview.setAdapter(adapter);
        }

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setClass(CustomMainActivity.this, CustomMealActivity.class);
                intent.putExtra("STORE_NAME", shopName[i]);
                intent.putExtra("DEL_PRICE",fee[i]);
                startActivity(intent);
            }
        });
    }
    public void HomeToCart(View v){
        Intent intent = new Intent();
        intent.setClass(this, CustomShopCartActivity.class);
        startActivity(intent);
    }
}