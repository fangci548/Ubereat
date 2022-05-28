package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class CustomShopCartActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private CustomItemList customItemList;
    TextView ShowitemTotal,totalFee,totalPay;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_shop_cart);

        customItemList=new CustomItemList(this);

        intView();
    }

    private void intView() {
        recyclerViewList = findViewById(R.id.recyclerViewList);
        ShowitemTotal = findViewById(R.id.ShowitemTotal);
        totalFee = findViewById(R.id.totalFee);
        totalPay = findViewById(R.id.totalPay);
    }
}