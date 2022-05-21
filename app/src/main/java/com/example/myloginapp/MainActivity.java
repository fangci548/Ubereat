package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    public static boolean VALID_USER = false;
    GridView gridview;

    String[] shopName = {"大苑子","麥當勞","必勝客","肯德基","可不可成熟紅茶","繼光香香雞"};
    int [] numberImage = {R.drawable.dayung,R.drawable.mcdonald,R.drawable.pizzahut,R.drawable.kfc,R.drawable.kebuketea,R.drawable.jgchicken};
    String[] fee = {"15.00","35.00","15.00","10.00","20.00","15.00"};
    String[] time = {"5-10","20-30","10-15","5-10","25-30","15-25"};
    String[] star = {"4.8","4.6","4.5","4.6","4.9","4.8"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!VALID_USER) {
            Intent intent = new Intent();
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
        } else {
            gridview = findViewById(R.id.gridview);

            MainAdapter adapter = new MainAdapter(MainActivity.this,shopName,numberImage,fee,time,star);
            gridview.setAdapter(adapter);
        }
    }


}