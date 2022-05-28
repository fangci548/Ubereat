package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class StoreOrderCompleteDetActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_store_order_complete_det);
  }

  public void onBack(View v) {

    setResult(RESULT_CANCELED);
    finish();
  }
}