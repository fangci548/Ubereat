package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class StoreOrderAcceptDetActivity extends AppCompatActivity {
  TextView mark;
  TextView num;
  TextView time;
  ListView listView;
  ArrayList<OrderDetailItem> arrayList = new ArrayList<>();
  OrderDetItemAdapter orderdetitemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orderaccept_det);
        arrayList.add(new OrderDetailItem("1", "漢堡", "x1", "60"));
        arrayList.add(new OrderDetailItem("2", "蛋餅", "x1", "30"));
        arrayList.add(new OrderDetailItem("3", "紅茶", "x1", "20"));
        listView = findViewById(R.id.orderdet_lv);
        orderdetitemAdapter = new OrderDetItemAdapter(this,R.layout.store_orderdetail_layout, arrayList);
        listView.setAdapter(orderdetitemAdapter);

        mark = findViewById(R.id.orderdet_mark);
        num = findViewById(R.id.orderdet_num);
        time = findViewById(R.id.orderdet_time);

        Intent intent = getIntent();
        mark.setText("#");
        num.setText(intent.getStringExtra("Num"));
        time.setText(intent.getStringExtra("Time"));



    }

  public void onBack(View v) {

    setResult(RESULT_CANCELED);
    finish();
  }
}