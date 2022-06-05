package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StoreOrderCompleteDetActivity extends AppCompatActivity {

  TextView mark;
  TextView num;
  TextView time;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_store_order_complete_det);

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